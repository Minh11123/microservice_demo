package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.config.AppException;
import codes.rytis.logindemo.config.ErrorResponseBase;
import codes.rytis.logindemo.entity.User;
import codes.rytis.logindemo.model.LoginRequest;
import codes.rytis.logindemo.model.LoginResponse;
import codes.rytis.logindemo.model.signup.SignupRequest;
import codes.rytis.logindemo.repository.UserRepository;
import codes.rytis.logindemo.service.AuthService;
import lombok.RequiredArgsConstructor;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final static Logger logger = Logger.getLogger(AuthController.class);
    private final AuthService authService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request) {
        return authService.attemptLogin(request.getEmail(), request.getPassword());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Validated SignupRequest signupRequest) {
        try {
            boolean emailExists = userRepository.existsByEmail(signupRequest.getEmail());
            if (emailExists) {
                throw new BadCredentialsException("Email nay da duoc su dung!");
            }
            // Thêm logic xử lý nếu email chưa tồn tại
            User user = User.builder()
                    .email(signupRequest.getEmail())
                    .phoneNumber(signupRequest.getPhone_number())
                    .fullName(signupRequest.getFullname())
                    .extraInfo(signupRequest.getExtraInfo())
                    .password(new BCryptPasswordEncoder().encode(signupRequest.getPassword()))
                    .role("USER")
                    .build();
            userRepository.save(user);
            logger.info("dang ki thanh cong :" + user.toString());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (AppException e) {
            throw new AppException(e);
        }
    }
}
