package ru.netology.autorizationservise.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.autorizationservise.Authorities;
import ru.netology.autorizationservise.exep.InvalidCredentials;
import ru.netology.autorizationservise.exep.UnauthorizedUser;
import ru.netology.autorizationservise.repository.UserRepository;

import java.util.List;
//@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

 //   public String gg (String name){
 //       return "hello    -   " + name;
 //   }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {//если данные пусты
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);

        if (isEmpty(userAuthorities)) { // если придет пустой список то нет такого пользоаптееля буде ошибка
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