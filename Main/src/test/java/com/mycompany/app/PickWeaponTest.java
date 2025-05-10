package com.mycompany.app;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mycompany.app.Weapon.Damage;


public class PickWeaponTest {
    /**
     * checks to make sure that the code doesn't crash when confronted with an edge case, and makes sure that a character with
     */
    @Test
    void testBasicWeaponSelection() {
        System.setIn(new ByteArrayInputStream("2\n".getBytes()));

        User user = new User();
        Character testMage = new Mage();

        Assertions.assertDoesNotThrow(() -> Main.pickWeapon(testMage, user));
        Assertions.assertEquals("Forbidden Tome", testMage.getWeapon().getName());
        Assertions.assertEquals(Item.Weight.BALANCED, testMage.getWeapon().getWeight());
    }

    /**
     * 
     */
    @Test
    void testInvalidInput() {
        System.setIn(new ByteArrayInputStream("5\n1\n".getBytes()));

        User user = new User();
        Character testArcher = new Archer();

        Assertions.assertDoesNotThrow(() -> Main.pickWeapon(testArcher, user));
        Assertions.assertEquals("Swiftstrike", testArcher.getWeapon().getName());
        Assertions.assertEquals(Damage.WEAK, testArcher.getWeapon().getDamage());
    }
}
