package ru.netology.autorizationservise.service;

import org.springframework.stereotype.Service;
import ru.netology.autorizationservise.Authorities;
import ru.netology.autorizationservise.exep.InvalidCredentials;
import ru.netology.autorizationservise.exep.UnauthorizedUser;
import ru.netology.autorizationservise.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {//если данные пусты
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (isEmpty(userAuthorities)) { // если придет пустой список
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}