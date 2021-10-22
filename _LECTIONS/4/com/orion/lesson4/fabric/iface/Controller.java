package com.orion.lesson4.fabric.iface;

import java.util.ArrayList;
import java.util.List;

import com.orion.lesson4.fabric.iface.RadioControllable.Radio;
import com.orion.lesson4.fabric.iface.RadioControllable.TV;

public class Controller {
    List<RadioControllable> devices = new ArrayList<>();


    public Controller(List<RadioControllable> devices) {
        this.devices = devices;
    }



    public void turnAll() {
        for (RadioControllable device : devices) {
            device.on();
        }
    }

    public void turnOffAll() {
        for (RadioControllable device : devices) {
            device.off();
        }
    }


    public static void main(String[] args) {
        TV one = new TV();
        TV another = new TV();
        Radio radio = new Radio();

        Controller controller = new Controller(List.of(one, another, radio));

        System.out.println("Включаем");
        controller.turnAll();
        printState(one, another, radio);


        System.out.println("Выключаем");
        controller.turnOffAll();
        printState(one, another, radio);


        one.printDeviceInformation();
        radio.printDeviceInformation();

    }

    private static void printState(TV one, TV another, Radio radio) {
        System.out.println(one.isTurnedOn());
        System.out.println(another.isTurnedOn());
        System.out.println(radio.isTurnedOn());
    }
}
