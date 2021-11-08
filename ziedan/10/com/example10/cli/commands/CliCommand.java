package com.example10.cli.commands;

import java.util.List;

public abstract class CliCommand {
    protected List<String> args;

    public CliCommand(List<String> args) {
        this.args = args;
    }

    public abstract void run();
}
