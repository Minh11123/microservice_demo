package com.auth.service;
import com.auth.config.AppException;
import com.auth.controller.AuthController;
import com.auth.model.LoginResponse;
import com.auth.security.CustomUserDetailService;
import com.auth.security.JwtIssuer;
import com.auth.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final static Logger logger = Logger.getLogger(AuthController.class);

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    public LoginResponse attemptLogin(String email, String password) throws AppException, AuthenticationException{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            var principal = (UserPrincipal) authentication.getPrincipal();
            var token = jwtIssuer.issue(JwtIssuer.Request.builder()
                    .userId(principal.getUserId())
                    .email(principal.getEmail())
                    .roles(principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build());

            return LoginResponse.builder()
                    .token(token)
                    .role(principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                    .build();
    }
}
