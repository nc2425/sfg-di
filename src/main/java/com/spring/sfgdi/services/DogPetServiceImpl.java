package com.spring.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dog", "default"})
public class DogPetServiceImpl implements PetService {

    @Override
    public String getPetType() {
        return "Dogs are the best!";
    }
}
