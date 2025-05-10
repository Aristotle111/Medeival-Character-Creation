package com.mycompany.app;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PickArmorTest {
    private Character tesCharacter;
    private User testUser;

    /**
     * tests that the code still works even after a false input
     */
    @Test
    void testInvalidInput() {
        System.setIn(new ByteArrayInputStream("0\n2\n3\n".getBytes()));
        Character testCharacter = new Swordsman();
        User testUser = new User();

        Assertions.assertThrows(SecurityException.class, () -> Main.pickArmor(testCharacter, testUser));

        Assertions.assertEquals("Chainmail", testCharacter.armor.name);
        Assertions.assertEquals(Item.Weight.BALANCED, testCharacter.armor.weight);
    }

    /**
     * tests that the code outputs the correct data
     */
    @Test
    void testvalidInput() {
        System.setIn(new ByteArrayInputStream("3\n3\n".getBytes()));
        Character testCharacter = new Swordsman();
        User testUser = new User();

        Assertions.assertThrows(SecurityException.class, () -> Main.pickArmor(testCharacter, testUser));

        Assertions.assertEquals("Leather", testCharacter.armor.name);
        Assertions.assertEquals(Item.Weight.LIGHT, testCharacter.armor.weight);
    }
}
