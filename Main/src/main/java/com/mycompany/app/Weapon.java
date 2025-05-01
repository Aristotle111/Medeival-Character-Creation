package com.mycompany.app;

abstract class Weapon extends Item implements Weildable {
    public enum damage {WEAK, MODERATE, STRONG};

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
