package ru.netology.autorizationservise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.autorizationservise.Authorities;
import ru.netology.autorizationservise.service.AuthorizationService;

import java.util.List;

@RestController

public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
//   public String w(@RequestParam("name") String name){
//       return service.gg(name);
//   }

    public List<Authorities> getAuthorities(@RequestParam("name") String name, @RequestParam("password") String password) { // @UserAnn User user
        return service.getAuthorities(name, password);
    }
}
