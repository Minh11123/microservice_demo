package codes.rytis.logindemo.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@JsonIgnoreProperties({"stackTrace", "cause", "suppressed","localizedMessage"})
@NoArgsConstructor

public class AppException extends RuntimeException {
    private Instant timestamp;
    private int code;
    private String message;
    private String path;

    public AppException(int code, String message, String path) {
        this.timestamp = Instant.now();
        this.code = code;
        this.message = message;
        this.path = path;
    }
    public AppException(ErrorResponseBase errorResponseBase){
        this.code = errorResponseBase.status.value();
        this.message = errorResponseBase.getMessage();
        this.timestamp = Instant.now();
    }
    public AppException(Exception ex) {
        String mes = ex.getMessage();
        if (mes == null) {
            this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
            this.message = "NullPointerException";
        } else if (mes.contains("Access Denied")) {
            this.code = ErrorResponseBase.UNAUTHORIZED.status.value();
            this.message = ErrorResponseBase.UNAUTHORIZED.getMessage();
        } else if (mes.contains("not found") || mes.contains("not exist") || mes.contains("NoSuchKey") || mes.contains("not_exist")) {
            this.code = ErrorResponseBase.NOT_FOUND.status.value();
            this.message = ErrorResponseBase.NOT_FOUND.getMessage();
        } else {
            this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
            this.message = ex.getMessage();
        }
        this.timestamp = Instant.now();
    }




}
