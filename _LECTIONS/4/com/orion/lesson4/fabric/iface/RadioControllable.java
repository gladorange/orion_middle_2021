package com.orion.lesson4.fabric.iface;

public interface RadioControllable {
    void on();
    void off();

    default void printDeviceInformation() {
        final String simpleName = getClass().getSimpleName();
        System.out.println("Это объект типа " + simpleName);
    }

    default void sayGoodBeyAndTurnOff() {
        System.out.println("Спокойной ночи");
        off();
    }



    public static class TV implements RadioControllable,ButtonControllable {

        boolean isTurnedOn = false;

        @Override
        public void on() {
            isTurnedOn = true;
            System.out.println("Телевизор включился");
        }

        @Override
        public void off() {
            isTurnedOn = false;
            System.out.println("Телевизор выключился");
        }

        public boolean isTurnedOn() {
            return isTurnedOn;
        }

        @Override
        public void pressOffButton() {
            off();
        }

        public void sayGoodBeyAndTurnOff() {
            ButtonControllable.super.sayGoodBeyAndTurnOff();
            RadioControllable.super.sayGoodBeyAndTurnOff();
        }


    }

    public static class Radio implements RadioControllable {

        boolean isTurnedOn = false;

        @Override
        public void on() {
            isTurnedOn = true;
            System.out.println("Радио включилося");
        }

        @Override
        public void off() {
            isTurnedOn = false;
            System.out.println("Радио выключилося");
        }

        public boolean isTurnedOn() {
            return isTurnedOn;
        }
    }

}
