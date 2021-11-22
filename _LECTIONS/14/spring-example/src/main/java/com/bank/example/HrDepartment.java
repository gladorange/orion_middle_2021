package com.bank.example;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

public class HrDepartment {

    final PersonnelDepartment personnelDepartment;

    public HrDepartment(PersonnelDepartment personnelDepartment) {
        this.personnelDepartment = personnelDepartment;
        lottery();
    }

  /*  @PostConstruct
    public void tryLottery() {

    }*/

    public void lottery() {
        final List<Client> allClients = personnelDepartment.getAllClients();
        final int luckyNumber = new Random().nextInt(allClients.size());
        allClients.get(luckyNumber).getAccounts().get(0).balance += 100;
        System.out.println("Счастливый пользователь  " + luckyNumber + " получает 100 рублей");

    }
}
