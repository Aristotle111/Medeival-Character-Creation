package com.mycompany.app;

import java.util.List;

public class Character {
    public int age;
    public String name;
    public List<Armor> armor;
    public List<Weapon> weapons;
    public Gender gender;

    public enum Gender {MALE, FEMALE};

    public Character() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.armor = null;
        this.weapons = null;
    }

    public Character(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Character(int age, String name, List<Armor> armor, Gender gender, List<Weapon> weapons) {
        this.age = age;
        this.name = name;
        this.armor = armor;
        this.gender = gender;
        this.weapons = weapons;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
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
        Character other = (Character) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[age = " + age + ", name = " + name + ", armor = " + armor + ", weapons = " + weapons + ", gender = "
                + gender + "]";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Armor> getArmor() {
        return armor;
    }

    public void setArmor(List<Armor> armor) {
        this.armor = armor;
    }
}
