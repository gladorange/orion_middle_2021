package com.example10.cli;


import com.example10.cli.commands.Console;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Console console = new Console();
        console.start();

    }

}
