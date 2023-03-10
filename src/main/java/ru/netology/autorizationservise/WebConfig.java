package ru.netology.autorizationservise;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.netology.autorizationservise.controller.AuthorizationController;
import ru.netology.autorizationservise.repository.UserRepository;
import ru.netology.autorizationservise.service.AuthorizationService;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserParamResolver());
    }
}