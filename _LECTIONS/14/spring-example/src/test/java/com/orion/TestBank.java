package com.orion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bank.example.Account;
import com.bank.example.Bank;
import com.bank.example.Bank.NotEnoughMoneyException;
import com.bank.example.Client;
import com.bank.example.PersonnelDepartment;

public class TestBank {

    @Test
    public void testSumInBank() {
        PersonnelDepartment p = new PersonnelDepartment() {
            @Override
            public List<Client> getAllClients() {
                List<Client> clients = new ArrayList<>();
                final Client vasya = new Client("Vasya", 1L);
                vasya.getAccounts().add(new Account(1, 100));

                final Client petya = new Client("Petya", 2L);
                petya.getAccounts().add(new Account(5, 0));

                clients.add(vasya);
                clients.add(petya);

                return clients;
            }
        };
        Bank b = new Bank(p);

        assertEquals("Sum should be 100", b.getAllMoney(), 100);
    }






    @Test
    public void testSumInBankNegative() {
        PersonnelDepartment p = new PersonnelDepartment() {
            @Override
            public List<Client> getAllClients() {
                List<Client> clients = new ArrayList<>();
                final Client vasya = new Client("Vasya", 1L);
                vasya.getAccounts().add(new Account(1, 100));

                final Client petya = new Client("Petya", 2L);
                vasya.getAccounts().add(new Account(5, -100));

                clients.add(vasya);
                clients.add(petya);

                return clients;
            }
        };
        Bank b = new Bank(p);


        assertEquals("Sum should be 100", b.getAllMoney(), 100);

    }



    @Test(expected = NotEnoughMoneyException.class)
    public void testTransferFail() {
        PersonnelDepartment p = new PersonnelDepartment() {
            @Override
            public List<Client> getAllClients() {
                final Client vasya = new Client("Vasya", 1L);
                vasya.getAccounts().add(new Account(1, 100));
                vasya.getAccounts().add(new Account(2, 200));

                final Client petya = new Client("Petya", 2L);
                petya.getAccounts().add(new Account(3, 1200));


                clients.add(vasya);
                clients.add(petya);
                return clients;
            }
        };

        Bank b = new Bank(p);
        b.transferBetweenPersons(1L, 2L, 400);
    }

    @Test
    public void testTransferOK() {
        PersonnelDepartment p = new PersonnelDepartment() {
            @Override
            public List<Client> getAllClients() {
                final Client vasya = new Client("Vasya", 1L);
                vasya.getAccounts().add(new Account(1, 100));
                vasya.getAccounts().add(new Account(2, 200));

                final Client petya = new Client("Petya", 2L);
                petya.getAccounts().add(new Account(3, 1200));


                clients.add(vasya);
                clients.add(petya);
                return clients;
            }
        };

        Bank b = new Bank(p);
        b.transferBetweenPersons(1L, 2L, 200);


        final List<Account> vasyaAccounts = p.findById(1L).getAccounts();

        assertThat(vasyaAccounts, hasItems(
                hasProperty("balance", equalTo(0)),
                hasProperty("balance", equalTo(100))
        ));

    }
}
