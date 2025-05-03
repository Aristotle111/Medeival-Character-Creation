package com.mycompany.app;

public class Weapon extends Item implements Weildable {
    public Damage damage;
    public String imageOfWeapon;

    public enum Damage {WEAK, MODERATE, STRONG};

    public Weapon() {
        super();
        this.damage = null;
        this.imageOfWeapon = null;
    }

    public Weapon(String nameOfItem, Weight weight, Damage damage, String imageOfWeapon) {
        super(nameOfItem, weight);
        this.damage = damage;
        this.imageOfWeapon = imageOfWeapon;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + imageOfWeapon;
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

    public String getImageOfWeapon() {
        return imageOfWeapon;
    }

    public void setImageOfWeapon(String imageOfWeapon) {
        this.imageOfWeapon = imageOfWeapon;
    }
}
