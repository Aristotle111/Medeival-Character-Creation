package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;

public class CharacterSetupTest {
    @Test
    void testInvalidClass() {
        System.setIn(new ByteArrayInputStream("Mag\nMage\nPMO\nmale\n25\n".getBytes()));

        User testUser = new User();
        Assertions.assertDoesNotThrow(() -> Main.characterSetup(testUser));
        
        Assertions.assertFalse(testUser.getCharacters().isEmpty());
    }

    @Test
    void testInvalidGender() {
        System.setIn(new ByteArrayInputStream("Archer\nGurt\nfemal\nfemale\n150\n".getBytes()));

        User testUser = new User();
        Assertions.assertDoesNotThrow(() -> Main.characterSetup(testUser));
        
        Assertions.assertEquals(Character.Gender.FEMALE, testUser.getCharacters().get(0).getGender());
    }

    @Test
    void testInvalidAge() {
        System.setIn(new ByteArrayInputStream("Swordsman\nYogurt\nmale\nold\n30\n".getBytes()));

        User testUser = new User();
        Assertions.assertDoesNotThrow(() -> Main.characterSetup(testUser));
        
        Assertions.assertEquals(30, testUser.getCharacters().get(0).getAge());
    }
}
