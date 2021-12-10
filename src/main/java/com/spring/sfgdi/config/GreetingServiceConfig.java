package com.spring.sfgdi.config;

import com.spring.sfgdi.repositories.EnglishGreetingRepository;
import com.spring.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.spring.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingServiceImpl i18nSpanishGreetingServiceImpl() {
        return new I18nSpanishGreetingServiceImpl();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingServiceImpl i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingServiceImpl(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingServiceImpl primaryGreetingServiceImpl() {
        return new PrimaryGreetingServiceImpl();
    }

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
