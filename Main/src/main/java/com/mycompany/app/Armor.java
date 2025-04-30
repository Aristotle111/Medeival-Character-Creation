package com.mycompany.app;

public class Armor extends Item implements Wearable {
    public Defense defense;

    public Armor(String name, Weight weight, Defense defense) {
        super(name, weight);
        this.defense = defense;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((defense == null) ? 0 : defense.hashCode());
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
        Armor other = (Armor) obj;
        if (defense != other.defense)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Armor [name=" + name + ", weight=" + weight + ", defense=" + defense + "]";
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }
}
