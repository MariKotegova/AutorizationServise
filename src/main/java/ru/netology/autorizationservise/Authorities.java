package ru.netology.autorizationservise;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.autorizationservise.exep.InvalidCredentials;
import ru.netology.autorizationservise.exep.UnauthorizedUser;

public enum Authorities {
    READ, WRITE, DELETE;


}
