package com.orion.lesson4.fabric.enums;

public class SeasonsAndTemp {


    public static void main(String[] args) {


    //    System.out.println(getAvgTemp("осень"));
       /* formatAvgTemp(Season.AUTUMN);
        formatAvgTemp(Season.SUMMER);
       formatAvgTemp(Season.WINTER);
        formatAvgTemp(Season.SPRING);
*/
        for (Season value : Season.values()) {
            formatAvgTemp(value);
        }
    }


    public static int getAvgTemp(Season season) {
        return switch (season) {
            case WINTER -> -10;
            case AUTUMN -> 5;
            case SUMMER -> 25;
            case SPRING -> 5;
        };
    }

    public static void formatAvgTemp(Season season) {
        System.out.printf("Название сезона %s, средняя температура %s%n", season.getRussianTitle(), getAvgTemp(season));
    }

    public enum Season {
        AUTUMN("Осень"), WINTER("Зима"), SPRING("Весна"), SUMMER("Лето");
        final String russianTitle;

        Season(String russianTitle) {
            this.russianTitle = russianTitle;
        }

        public String getRussianTitle() {
            return russianTitle;
        }
    }
}
