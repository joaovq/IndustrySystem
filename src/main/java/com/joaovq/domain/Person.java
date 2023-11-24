package com.joaovq.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private LocalDate birth;

    public Person(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }
    public String getBirthFormatted(String patternString) {
        String pattern = patternString == null ? "dd/MM/yyyy" : patternString;
        return birth.format(DateTimeFormatter.ofPattern(pattern));
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getAge() {
        return birth.until(LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
