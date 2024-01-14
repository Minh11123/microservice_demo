package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.entity.User;
import codes.rytis.logindemo.model.LoginRequest;
import codes.rytis.logindemo.model.LoginResponse;
import codes.rytis.logindemo.model.signup.SignupRequest;
import codes.rytis.logindemo.repository.UserRepository;
import codes.rytis.logindemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Validated SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return new ResponseEntity<>("Email da ton tai!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setExtraInfo(signupRequest.getEmail());
        String password = new BCryptPasswordEncoder().encode(signupRequest.getPassword());
        user.setPassword(password);
        user.setRole("USER");
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
