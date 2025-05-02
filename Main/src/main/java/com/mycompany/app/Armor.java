package com.mycompany.app;

public class Armor extends Item implements Wearable {
    public Defense defense;

    public enum Defense {WEAK, MODERATE, STRONG};

    public Armor() {
        super();
        this.defense = null;
    }

    public Armor(String nameOfItem, Weight weight, Defense defense) {
        super(nameOfItem, weight);
        this.defense = defense;
    }

    @Override
    public void wear() {
    }

    @Override
    public String toString() {
        return "Armor " + super.toString();
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }
}
