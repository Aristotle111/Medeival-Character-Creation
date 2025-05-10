package com.mycompany.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mycompany.app.Main.WeaponDamageComparator;

public class WeaponDamageComparatorTest {
    private final WeaponDamageComparator comparator = new WeaponDamageComparator();
    
    private Character createCharacter(String name, Weapon.Damage damage) {
        Character character = new Character();
        character.name = name;
        if (damage != null) {
            character.weapon = new Weapon();
            character.weapon.damage = damage;
        }
        return character;
    }

    @Test
    void compare_BothNull() {
        Character c1 = createCharacter("Gurt", null);
        Character c2 = createCharacter("PMO", null);
        Assertions.assertEquals(0, comparator.compare(c1, c2));
    }

    @Test
    void compare_NormalInputs() {
        Character c1 = createCharacter("Yogurt", Weapon.Damage.WEAK);
        Character c2 = createCharacter("Yo", Weapon.Damage.BALANCED);
        Assertions.assertTrue(comparator.compare(c1, c2) < 0);
    }
}
