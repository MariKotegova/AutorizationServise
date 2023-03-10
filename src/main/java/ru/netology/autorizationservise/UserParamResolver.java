package ru.netology.autorizationservise;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.netology.autorizationservise.domain.Person;
import ru.netology.autorizationservise.exep.InvalidCredentials;
import ru.netology.autorizationservise.myJavaConfig.JavaConfig;

import javax.sound.midi.Instrument;

import static sun.util.locale.LocaleUtils.isEmpty;

public class UserParamResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Person.class);
        //hasParameterAnnotation();
//        return parameter.hasParameterAnnotation(UserValidated.class) &&
//                parameter.getParameterType().equals(Person.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

         String userName = webRequest.getParameter("name");
                String password = webRequest.getParameter("password");
        ////
                if (isEmpty(userName) || isEmpty(password)) {
                    throw new InvalidCredentials("User name or password is empty");
                }
//
        return new Person(userName, password);

    }


 //   private boolean isEmpty(String str) {
 //       return str == null || str.isEmpty();
 //   }
}
