package com.bank.example;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Client {

    final String name;
    final Long id;

    List<Account> accounts = new ArrayList<>();
}
