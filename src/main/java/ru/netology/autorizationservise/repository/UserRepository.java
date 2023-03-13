package ru.netology.autorizationservise.repository;

import org.springframework.stereotype.Repository;
import ru.netology.autorizationservise.Authorities;
import ru.netology.autorizationservise.domain.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {
    List<Person> repository;

    public UserRepository() {
        repository = new ArrayList<>();
        repository.add(new Person("Ivan", "111", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        repository.add(new Person("Katya", "222", Arrays.asList(Authorities.READ, Authorities.WRITE)));
        repository.add(new Person("Oleg", "333", Arrays.asList(Authorities.READ)));
    }

    // реализовать
    public List<Authorities> getUserAuthorities(String user, String password) {
        for (Person p : repository) {
            if (p.getName().equals(user) && p.getPassword().equals(password)) {
                return p.getListAuthorities();
            }
        }
        return new ArrayList<>();
    }
}
