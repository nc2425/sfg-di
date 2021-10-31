package com.spring.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("cat")
public class CatPetServiceImpl implements PetService {

    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
