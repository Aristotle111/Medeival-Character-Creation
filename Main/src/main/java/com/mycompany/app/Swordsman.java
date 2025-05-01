package com.mycompany.app;

public class Swordsman extends Character {

    public Swordsman() {
        super();
    }

    public Swordsman(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return "Swordsman " + super.toString();
    }
}
