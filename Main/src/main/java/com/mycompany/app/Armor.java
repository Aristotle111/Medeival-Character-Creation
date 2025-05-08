package com.mycompany.app;

public class Armor extends Item implements Wearable {
    public Defense defense;
    public String imageOfArmor;

    public enum Defense {WEAK, MODERATE, STRONG};

    public Armor() {
        super();
        this.defense = null;
        this.imageOfArmor = null;
    }

    public Armor(String nameOfItem, Weight weight, Defense defense, String imageOfArmor) {
        super(nameOfItem, weight);
        this.defense = defense;
        this.imageOfArmor = imageOfArmor;
    }

    @Override
    public void wear() {
        System.out.println("The armor has been equipped, it's perfect");
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + imageOfArmor;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public String getImageOfArmor() {
        return imageOfArmor;
    }

    public void setImageOfArmor(String imageOfArmor) {
        this.imageOfArmor = imageOfArmor;
    }
}
