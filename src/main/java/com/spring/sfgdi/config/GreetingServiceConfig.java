package com.spring.sfgdi.config;

import com.spring.sfgdi.services.ConstructorGreetingServiceImpl;
import com.spring.sfgdi.services.PropertyGreetingServiceImpl;
import com.spring.sfgdi.services.SetterGreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingServiceImpl constructorGreetingServiceImpl() {
        return new ConstructorGreetingServiceImpl();
    }

    @Bean
    PropertyGreetingServiceImpl propertyGreetingServiceImpl() {
        return new PropertyGreetingServiceImpl();
    }

    @Bean
    SetterGreetingServiceImpl setterGreetingServiceImpl() {
        return new SetterGreetingServiceImpl();
    }
}
