package com.mycompany.app;

public class Armor extends Item implements Wearable {
    public enum defense {WEAK, MODERATE, STRONG};

    public Armor(String name) {
        super(name);
    }
}
