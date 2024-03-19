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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                throw new AppException(ErrorResponseBase.IS_EXISTED);
            }
            logger.info("not exist user by email");
            // Thêm logic xử lý nếu email chưa tồn tại
        } catch (AppException e) {
            logger.error("Error: Email already exists: {}" + signupRequest.getEmail(), e);
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error occurred", e);
            // Xử lý các lỗi khác nếu cần
        }

        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPhoneNumber(signupRequest.getPhone_number());
        user.setFullName(signupRequest.getFullname());
        user.setExtraInfo(signupRequest.getEmail());
        String password = new BCryptPasswordEncoder().encode(signupRequest.getPassword());
        user.setPassword(password);
        user.setRole("USER");
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
