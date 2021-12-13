package com.spring.sfgdi.config;

import com.spring.sfgdi.datasource.FakeDataSource;
import com.spring.sfgdi.repositories.EnglishGreetingRepository;
import com.spring.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.spring.sfgdi.services.*;
import org.example.pets.PetService;
import org.example.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(sfgConfiguration.getUsername());
        fakeDataSource.setPassword(sfgConfiguration.getPassword());
        fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

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
    PropertyGreetingServiceImpl propertyGreetingServiceImpl() {
        return new PropertyGreetingServiceImpl();
    }

    @Bean
    SetterGreetingServiceImpl setterGreetingServiceImpl() {
        return new SetterGreetingServiceImpl();
    }
}
