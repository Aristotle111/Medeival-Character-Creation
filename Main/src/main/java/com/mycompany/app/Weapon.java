package com.mycompany.app;

public class Weapon extends Item implements Weildable {
    public enum Damage {WEAK, MODERATE, STRONG};

    public Weapon(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Weapon " + super.toString();
    }

    @Override
    public void weild() {
        
    }
}
