package com.auth.model.signup;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;




@Data
public class SignupRequest {

    @NotEmpty(message = "email khong duoc de trong!")
    @Email(message = "email khong hop le!")
    private final String email;

    @NotEmpty(message = "fullname khong duoc de trong")
    private final String fullname;
    private final String phone_number;
    @NotEmpty(message = "password khong duoc de trong")
    private final String password;
    private final String extraInfo;
}
