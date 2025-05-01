package com.mycompany.app;

abstract class Armor extends Item implements Wearable {
    public enum Defense {WEAK, MODERATE, STRONG};

    public Armor(String name) {
        super(name);
    }

    @Override
    public void wear() {
        
    }
}
