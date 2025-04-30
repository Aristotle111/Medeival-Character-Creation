package com.mycompany.app;

public class Weapon extends Item implements Weildable {
    public WeaponDamage damage;

    public Weapon(String name, Weight weight, WeaponDamage damage) {
        super(name, weight);
        this.damage = damage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((damage == null) ? 0 : damage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Weapon other = (Weapon) obj;
        if (damage != other.damage)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Weapon [name=" + name + ", damage=" + damage + ", weight=" + weight + "]";
    }

    public WeaponDamage getDamage() {
        return damage;
    }

    public void setDamage(WeaponDamage damage) {
        this.damage = damage;
    }
}
