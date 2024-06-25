package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.config.AppException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class AppExceptionHandler {
    private final static Logger logger = Logger.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(AppException.class)
    public ResponseEntity<AppException> globalExceptionHandler(AppException ex, HttpServletRequest request) {
        ex.setPath(request.getRequestURI());
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(ex, HttpStatus.valueOf(ex.getCode()));
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppException> handleBindException(BindException e, HttpServletRequest request) {
        String errorMessage = "";
        if (e.getBindingResult().hasErrors()){
            for(int i=0;i< e.getBindingResult().getAllErrors().size();i++){
                errorMessage += e.getBindingResult().getAllErrors().get(i).getDefaultMessage();
                errorMessage += (i==e.getBindingResult().getAllErrors().size()-1) ? "." : ", ";
            }
        }
        AppException appException= new AppException(400,errorMessage + " Okok", request.getRequestURI());
        logger.error(e.getMessage() + "okok", e);
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getCode()));
    }


    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<AppException> authen(BadCredentialsException e, HttpServletRequest request) {
        AppException appException= new AppException(401,e.getMessage() + " ok e", request.getRequestURI());
        logger.error(e.getMessage(),e);
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getCode()));
    }
}
