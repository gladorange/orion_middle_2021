package com.lesson16;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;


@Service
public class JpaService {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    TransactionTemplate transactionTemplate;


    @Autowired
    CreateTestAnimalService anotherService;

    @Transactional(rollbackFor = Throwable.class)
    public void createAnimal() {
        throw new RuntimeException("не создалось");
        //em.persist(new Animal("test", "cat"));
    }

    public static class AnimalException extends Exception {
        public AnimalException(String message) {
            super(message);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateAnimal() {
        final Animal test = em.find(Animal.class, "test");
        test.type = "cat22";
    }


    public void nonTransactionalMethod() throws AnimalException {
        transactionTemplate.executeWithoutResult(tr -> updateAnimal());
    }

    @Transactional(rollbackFor = Exception.class) // транзакция открылась
    public void createAnimals() {

        for (int i = 0; i < 3; i++) {
            em.persist(new Animal("test" + i, "cat"));
        }

        try {
            anotherService.createAnimal(); // транзакция открылась???
        } catch (Exception e ) {
            System.out.println("Не создалось ну и ладно");
        }

        //  // транзакция комитится
    }



}
