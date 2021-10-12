package com.orion.lesson4.fabric.ui;

import com.orion.lesson4.fabric.ui.ExtendedButton.ClickCallback;

public class AbstractButtonExample {


    public static void main(String[] args) {
       // checkSimpleButton();
        checkExtendedButton();


    }

    private static void checkSimpleButton() {
        Button openMenuButton = new Button("Открыть меню") {
            @Override
            public void click(Button button) {
                System.out.println("Меню открылось");
            }
        };

        Button closeMenuButton = new Button("Закрыть меню") {
            @Override
            public void click(Button button) {
                System.out.println("Меню закрылось");
            }
        };


        openMenuButton.click(openMenuButton);
        closeMenuButton.click(closeMenuButton);
    }


    private static void checkExtendedButton() {
        final ClickCallback clickCallback = (Button button) -> System.out.println("Меню открылось");
        ExtendedButton openMenuButton = new ExtendedButton("Открыть меню", clickCallback);
        ExtendedButton openMenuButton2 = new ExtendedButton("Открыть меню 2", clickCallback);
        openMenuButton.click(openMenuButton);
        openMenuButton.click(openMenuButton2);
    }
}
