package codes.rytis.logindemo.model.signup;


import lombok.Data;

@Data
public class SignupRequest {
    private final String email;
    private final String fullname;
    private final String phone_number;
    private final String password;
    private final String extraInfo;
}
