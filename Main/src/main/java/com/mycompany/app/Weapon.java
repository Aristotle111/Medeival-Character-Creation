package com.mycompany.app;

public class Weapon extends Item implements Weildable {
    public Damage damage;

    public enum Damage {WEAK, MODERATE, STRONG};

    public Weapon() {
        super();
        this.damage = null;
    }

    public Weapon(String nameOfItem, Weight weight, Damage damage) {
        super(nameOfItem, weight);
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Weapon " + super.toString();
    }

    @Override
    public void weild() {
        
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }
}
