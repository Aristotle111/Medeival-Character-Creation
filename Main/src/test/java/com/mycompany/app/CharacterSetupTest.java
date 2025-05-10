package com.mycompany.app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;

public class CharacterSetupTest {
    /**
     * checks to make sure that the code doesn't crash when confronted with an edge case, and makes sure that a character is still made despite this
     */
    @Test
    void testInvalidClass() {
        System.setIn(new ByteArrayInputStream("Mag\nMage\nPMO\nmale\n25\n".getBytes()));

        User testUser = new User();
        Assertions.assertDoesNotThrow(() -> Main.characterSetup(testUser));
        
        Assertions.assertFalse(testUser.getCharacters().isEmpty());
    }

    /**
     * checks to make sure that the code doesn't crash when confronted with an edge case, and makes sure that the input that got through was the intended input
      */
    @Test
    void testInvalidGender() {
        System.setIn(new ByteArrayInputStream("Archer\nGurt\nfemal\nfemale\n150\n".getBytes()));

        User testUser = new User();
        Assertions.assertDoesNotThrow(() -> Main.characterSetup(testUser));
        
        Assertions.assertEquals(Character.Gender.FEMALE, testUser.getCharacters().get(0).getGender());
    }

    /**
     * checks to make sure that the code doesn't crash when confronted with an edge case, and makes sure that the input that got through was the intended input
     */
    @Test
    void testInvalidAge() {
        System.setIn(new ByteArrayInputStream("Swordsman\nYogurt\nmale\nold\n30\n".getBytes()));

        User testUser = new User();
        Assertions.assertDoesNotThrow(() -> Main.characterSetup(testUser));
        
        Assertions.assertEquals(30, testUser.getCharacters().get(0).getAge());
    }
}
