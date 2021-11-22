package com.bank.example;


import org.springframework.scheduling.annotation.Async;

import lombok.SneakyThrows;

public class Bank {


    public static class NotEnoughMoneyException extends RuntimeException {
        public NotEnoughMoneyException(long personId,int amount) {
            super("Person with id " + personId + " doesn't have " + amount);
        }
    }

    private final PersonnelDepartment p;

    public Bank(PersonnelDepartment p) {
        this.p = p;
    }


    public long getAllMoney() {
        return p.getAllClients().stream()
                .flatMap(p -> p.accounts.stream())
                .mapToInt(Account::getBalance)
                .filter( sum -> sum > 0)
                .sum();
    }

    public void transferBetweenPersons(Long sourcePersonId, Long destinationPersonId, int amount) {
        final Client source = p.findById(sourcePersonId);
        final Client target  = p.findById(destinationPersonId);


        int currentAmount = amount;
        for (Account account : source.getAccounts()) {
            int toDecrease = Math.min(currentAmount, account.balance);
            account.balance -= toDecrease;
            currentAmount -= toDecrease;
        }

        if (currentAmount > 0) {
            throw new NotEnoughMoneyException(sourcePersonId, amount);
        }

        target.getAccounts().get(0).balance += amount;

    }


    public static void main(String[] args) {
        Bank b = new Bank(new PersonnelDepartment());

        b.transferBetweenPersons(1L,2L,200);
        System.out.println(b.getAllMoney());
    }

    @SneakyThrows
    @Async
    public void asyncExecution() {
        Thread.sleep(5000);
        System.out.println("async");
    }
}
