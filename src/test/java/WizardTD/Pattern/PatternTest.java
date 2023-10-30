package WizardTD.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PatternTest {
    /**
     * Test getter methods in Pattern.
     */
    @Test
    void testGetter() {
        Grass grass = new Grass(2, 3);
        assertEquals("grass.png", grass.getType());
        assertEquals(2, grass.getX());
        assertEquals(3, grass.getY());
    }

    /**
     * Test setType(String) method in Pattern.
     */
    @Test
    void testSetType() {
        Grass grass = new Grass(2, 3);
        grass.setType("test");
        assertEquals("test", grass.getType());
    }
}

