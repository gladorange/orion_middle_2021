package com.lesson16;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTestAnimalService {


    @Transactional(rollbackFor = Throwable.class)
    public void createAnimal() {
        throw new RuntimeException("не создалось");
        //em.persist(new Animal("test", "cat"));
    }
}
