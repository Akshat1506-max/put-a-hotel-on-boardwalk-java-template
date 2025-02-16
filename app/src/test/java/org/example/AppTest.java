package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test 
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    
    @Test
    void testBoardMovement() {
        App app = new App();
        assertEquals("Go", app.getCurrentSpace());
        app.step();
        assertEquals("Mediterranean Avenue", app.getCurrentSpace());
    }
    
    @Test
    void testCircularBehavior() {
        App app = new App();
        // Step through all spaces to get back to Go
        for (int i = 0; i < 5; i++) {
            app.step();
        }
        assertEquals("Go", app.getCurrentSpace());
    }
}