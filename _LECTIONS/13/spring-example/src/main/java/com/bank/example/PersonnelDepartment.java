package com.bank.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PersonnelDepartment {

    protected List<Client> clients = new ArrayList<>();

    public PersonnelDepartment() {
        final Client vasya = new Client("Vasya", 1L);
        vasya.accounts.add(new Account(1, 100));
        vasya.accounts.add(new Account(2, 200));

        final Client petya = new Client("Petya", 2L);
        petya.accounts.add(new Account(3, 1200));


        clients.add(vasya);
        clients.add(petya);

        System.out.println("PersonnelDepartment создался" );
    }

    public List<Client> getAllClients() {


        return clients;

    }


    public Client findById(long id) {
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
