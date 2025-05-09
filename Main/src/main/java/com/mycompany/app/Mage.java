package com.mycompany.app;

public class Mage extends Character {
    public Mage() {
        super();
    }

    public Mage(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return " Mage ]" + super.toString();
    }
}
