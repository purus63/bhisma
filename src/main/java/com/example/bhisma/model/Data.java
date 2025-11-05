package com.example.bhisma.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Data {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Data(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
