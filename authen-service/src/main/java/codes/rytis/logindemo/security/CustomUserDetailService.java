package codes.rytis.logindemo.security;

import codes.rytis.logindemo.config.AppException;
import codes.rytis.logindemo.config.ErrorResponseBase;
import codes.rytis.logindemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private static final Logger logger = Logger.getLogger(CustomUserDetailService.class);
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userService.findByEmail(username).orElseThrow(()-> {
            logger.error("User not exit with username : " + username);
            return new AppException(ErrorResponseBase.USER_NOT_EXISTED);
        });
        return UserPrincipal.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(user.getRole())))
                .build();
    }
}
