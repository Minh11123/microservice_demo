package com.example.job_service.config.Exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<AppException> globalExceptionHandler(AppException ex, HttpServletRequest request) {
        ex.setPath(request.getRequestURI());
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
        AppException appException= new AppException(400,errorMessage, request.getRequestURI());
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getCode()));
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<AppException> author(BadCredentialsException e, HttpServletRequest request) {
        AppException appException= new AppException(401,e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getCode()));
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<AppException> authen(AuthenticationException e, HttpServletRequest request) {
        AppException appException= new AppException(400,e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getCode()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<AppException> ex(Exception e, HttpServletRequest request) {
        AppException appException= new AppException(500,e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(appException, HttpStatus.valueOf(appException.getCode()));
    }

}
