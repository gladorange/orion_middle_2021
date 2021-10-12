package com.orion.lesson4.fabric.ui;

public class ExtendedButton extends Button implements Clickable {

    interface ClickCallback {
        void click(Button button);
    }

    final String caption;
    private final ClickCallback callback;

    @Override
    public void click(Button button) {
        callback.click(this);
    }

    public ExtendedButton(String caption, ClickCallback callback) {
        super(caption);
        this.caption = caption;
        this.callback = callback;
    }



}
