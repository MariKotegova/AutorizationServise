package ru.netology.autorizationservise.exep;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class ExeptionHeandler {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> ieaHangler(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> reHangler(UnauthorizedUser r) {
        System.out.println(r.getMessage());
        return new ResponseEntity<>(r.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}