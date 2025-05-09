package com.mycompany.app;

public abstract class Item extends Character {
    public String nameOfItem;
    public Weight weight;

    public enum Weight {HEAVY, BALANCED, LIGHT};

    public Item() {
        this.nameOfItem = null;
        this.weight = null;
    }

    public Item(String nameOfItem, Weight weight) {
        this.nameOfItem = nameOfItem;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[ type: " + nameOfItem + ", weight: " + weight + " ]";
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
}
