package ru.netology.autorizationservise.repository;

import org.springframework.stereotype.Repository;
import ru.netology.autorizationservise.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.apache.logging.log4j.util.Strings.isEmpty;

//@Repository
public class UserRepository {
    Map<String, String> repository;
    public UserRepository(){
        repository = new ConcurrentHashMap<>();
        repository.put("Ivan", "111");
        repository.put("Katya", "222");
    }
    // реализовать
    public List<Authorities> getUserAuthorities(String user, String password) {
        List <Authorities> list = new ArrayList<>();

        if (repository.containsKey(user) && repository.get(user).equals(password)) {
            list.add(Authorities.READ);
            list.add(Authorities.WRITE);
            list.add(Authorities.DELETE);
            return list;
        }
        return list;
    }
}
