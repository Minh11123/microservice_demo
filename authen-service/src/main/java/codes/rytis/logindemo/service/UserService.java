package codes.rytis.logindemo.service;

import codes.rytis.logindemo.config.AppException;
import codes.rytis.logindemo.entity.User;
import codes.rytis.logindemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String OTHER_EMAIL = "other@test.com";

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        // All of this code would come from the database, but for simplicity of this example
        // Let's just fake it

        try {
            return Optional.ofNullable(userRepository.findByEmail(email));
        }catch (Exception e){
            throw new AppException(e);
        }
    }
}
