package ru.netology.autorizationservise.myJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.autorizationservise.repository.UserRepository;
import ru.netology.autorizationservise.service.AuthorizationService;

@Configuration
public class JavaConfig {
    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
