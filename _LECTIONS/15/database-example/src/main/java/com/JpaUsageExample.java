package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Animal;
import com.entity.Person;

public class JpaUsageExample {

    final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ru.evilorange.default-unit");

    public static void main(String[] args) {

        //detachExample();
     /*   final EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        final Animal sharik = new Animal("sharik", "dog");
        final Animal barsik = new Animal("barsik", "cat");

     //   entityManager.merge(sharik);
    //    entityManager.merge(barsik);



        final Query selectAnimals = entityManager.createQuery("SELECT a FROM Animal a where a.type='cat'");
        final List<Animal> resultList = selectAnimals.getResultList();
        System.out.println(resultList);


        entityManager.merge(new Person("Vasya","Pupkin", "programmer"));

        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Конец");*/
/*
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ru.evilorange.default-unit");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(new Author("Vasya","Pupkin"));

        final Author entity = new Author("Petya", "Ivanov");
        entityManager.persist(entity);


        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();




        final List<Author> resultList = entityManager
                .createQuery("SELECT a from Author a where a.name=:name", Author.class)
                .setParameter("name","Petya")
                .getResultList();

        final Author author = resultList.get(0);

        author.setLastName("Not-iVanov");

        entityManager.getTransaction().commit();
        entityManager.close();




        final EntityManager anotherEm = entityManagerFactory.createEntityManager();
        anotherEm.getTransaction().begin();

        final Author merge = anotherEm.merge(author);
        anotherEm.getTransaction().commit();*/

    }

    private static void detachExample() {
        final EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        final Animal sharik = entityManager.find(Animal.class, "sharik");


        entityManager.detach(sharik);

        System.out.println(sharik);
        sharik.setType("dog");

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
