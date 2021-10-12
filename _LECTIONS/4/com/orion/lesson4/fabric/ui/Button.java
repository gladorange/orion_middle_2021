package com.orion.lesson4.fabric.ui;

public abstract class Button implements Clickable {

    final String caption;

    public Button(String caption) {
        this.caption = caption;
    }

}
