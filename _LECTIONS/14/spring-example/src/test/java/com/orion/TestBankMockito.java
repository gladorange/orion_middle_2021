package com.orion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bank.example.Account;
import com.bank.example.Bank;
import com.bank.example.Bank.NotEnoughMoneyException;
import com.bank.example.Client;
import com.bank.example.PersonnelDepartment;

public class TestBankMockito {


    @Test
    public void testFindByID() {
        final PersonnelDepartment mock = mock(PersonnelDepartment.class);

        final Client vasya = new Client("Vasya", 1L);

        when(mock.findById(1L)).thenReturn(vasya);
        when( mock.findById(anyLong()) ).thenReturn(vasya);



        when(mock.findByIdAndName(anyLong(), any())).thenAnswer((Answer<Client>) invocation -> {
            final Long id = invocation.getArgumentAt(0, Long.class);
            final String name = invocation.getArgumentAt(1, String.class);
            return new Client(name, id);
        });




        assertEquals(mock.findById(1L), vasya);
        assertEquals(mock.findById(2L), vasya);
        assertEquals(mock.findById(3L), vasya);
        assertEquals(mock.findById(4L), vasya);
        assertEquals(mock.findById(5L), vasya);


        assertEquals(mock.findByIdAndName(1L, "Vasya"), new Client("Vasya", 1L));
        assertEquals(mock.findByIdAndName(2L, "Petya"), new Client("Petya", 2L));
        assertEquals(mock.findByIdAndName(3L, "Masha"), new Client("Masha", 3L));


    }

    @Test
    public void testSumInBank() {

        List<Client> clients = new ArrayList<>();
        final Client vasya = new Client("Vasya", 1L);
        vasya.getAccounts().add(new Account(1, 100));

        final Client petya = new Client("Petya", 2L);
        petya.getAccounts().add(new Account(5, 0));

        clients.add(vasya);
        clients.add(petya);

        final PersonnelDepartment mock = mock(PersonnelDepartment.class);

        when(mock.getAllClients()).thenReturn(clients);

        System.out.println(mock.getAllClients());
        Bank b = new Bank(mock);

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
