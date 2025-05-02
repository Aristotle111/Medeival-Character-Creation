package com.mycompany.app;

public class Armor extends Item implements Wearable {
    public enum Defense {WEAK, MODERATE, STRONG};

    public Armor(String name) {
        super(name);
    }

    @Override
    public void wear() {
        
    }

    @Override
    public String toString() {
        return "Armor " + super.toString();
    }
}
