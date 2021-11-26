package com;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.entity.Animal;
import com.entity.Person;

public class JpaExample2 {

    final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ru.evilorange.default-unit");


    public static void main(String[] args) {

        final EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();


        final TypedQuery<Animal> query = entityManager.createQuery("SELECT a from Animal a WHERE a.type='dog'", Animal.class);
        final List<Animal> resultList = query.getResultList();
        System.out.println(resultList);
        final Animal sharik = resultList.get(0);
        sharik.setType("lion");
        //    entityManager.detach(sharik); убирает из контекста
        //    entityManager.close(); - уничтожает контекст

        final Person vasya = entityManager.find(Person.class, "Vasya");
        System.out.println(vasya.getAnimals());

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
