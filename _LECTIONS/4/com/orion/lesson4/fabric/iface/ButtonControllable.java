package com.orion.lesson4.fabric.iface;

public interface ButtonControllable {

    void pressOffButton();

    default void sayGoodBeyAndTurnOff() {
        System.out.println("Спокойной ночи от кнопки");
        pressOffButton();
    }
}
