package com.mycompany.app;

public class Archer extends Character {
    public Archer() {
        super();
    }

    public Archer(int age, String name) {
        super(age, name);
    }

    @Override
    public String toString() {
        return " Archer ]" + super.toString();
    }
}
