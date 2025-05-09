package com.mycompany.app;

public class Character extends User implements Comparable<Character> {
    public int age;
    public String name;
    public Armor armor;
    public Weapon weapon;
    public Gender gender;

    public enum Gender {MALE, FEMALE};

    public Character() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.armor = null;
        this.weapon = null;
    }

    public Character(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Character(int age, String name, Armor armor, Gender gender, Weapon weapon) {
        this.age = age;
        this.name = name;
        this.armor = armor;
        this.gender = gender;
        this.weapon = weapon;
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
        return "\n[ name: " + name + " ]\n" + "[ age: " + age + " ]\n" + "[ gender: "
        + gender + " ]\n" + "[ armor: " + armor + "\n\n" + "[ weapon: " + weapon + "\n";
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

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Compares this character with another character for order based on their names.
     */
    @Override
    public int compareTo(Character other) {
        if (this.name == null && other.name == null) {
            return 0;
        }
        if (this.name == null) {
            return -1;
        }
        if (other.name == null) {
            return 1;
        }
        return this.name.compareToIgnoreCase(other.name);
    }
}
