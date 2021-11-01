package com.example8.lectures;

import java.time.LocalDate;

public class Lecture {
    private String name;
    private LocalDate date;

    public Lecture(String name, LocalDate startDate) {
        this.name = name;
        this.date = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
