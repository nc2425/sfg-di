package com.spring.sfgdi.services;

import com.spring.sfgdi.repositories.EnglishGreetingRepository;

public class I18nEnglishGreetingServiceImpl implements GreetingService {

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingServiceImpl(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
