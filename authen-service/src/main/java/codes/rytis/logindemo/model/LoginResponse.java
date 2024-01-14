package codes.rytis.logindemo.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class LoginResponse {
    private String token;
    private List<String> role;
}
