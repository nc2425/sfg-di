package com.spring.sfgdi.controllers;

import com.spring.sfgdi.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting() {

        return greetingService.sayGreeting();
    }
}
