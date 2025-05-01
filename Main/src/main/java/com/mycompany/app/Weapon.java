package com.mycompany.app;

abstract class Weapon extends Item implements Weildable {
    public enum Damage {WEAK, MODERATE, STRONG};

    public Weapon(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Weapon [name=" + name + "]";
    }

    @Override
    public void weild() {
        
    }
}
