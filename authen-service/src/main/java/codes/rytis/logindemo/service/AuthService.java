package codes.rytis.logindemo.service;

import codes.rytis.logindemo.config.AppException;
import codes.rytis.logindemo.config.ErrorResponseBase;
import codes.rytis.logindemo.model.LoginResponse;
import codes.rytis.logindemo.security.CustomUserDetailService;
import codes.rytis.logindemo.security.JwtIssuer;
import codes.rytis.logindemo.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    public LoginResponse attemptLogin(String email, String password) {
        try {
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
        }catch (Exception e){
            throw  new AppException(ErrorResponseBase.USER_NOT_EXISTED);
        }
    }
}
