package com.mycompany.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserSetupTest {
    /**
     * checks to make sure that the code doesn't crash when confronted with an edge case
     */
     @Test
        void testEmptyUsernameRetry() {
            InputStream inputTest = new ByteArrayInputStream("\nJohn\n1\n".getBytes());
            System.setIn(inputTest);
    
            Assertions.assertDoesNotThrow(() -> Main.userSetup());
        }
        
        /**
        * checks to make sure that the code doesn't crash when confronted with an edge case
        */
        @Test
        void testInvalidMenuChoiceRetry() {
            System.setIn(new ByteArrayInputStream("Jane\n5\n2\n".getBytes()));
    
            Assertions.assertDoesNotThrow(() -> Main.userSetup());
        }
}
