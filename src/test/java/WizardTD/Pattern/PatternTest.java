package WizardTD.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import WizardTD.App;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PatternTest {
    /**
     * Method under test: {@link Pattern#setType(String)}
     */
    @Test
    void constructor() {
        Grass grass = new Grass(2, 3);
        assertEquals("grass.png", grass.getType());
        assertEquals(2, grass.getX());
        assertEquals(3, grass.getY());
    }

    /**
     * Method under test: {@link Pattern#getType()}
     */
    @Test
    void testSetType() {
        Grass grass = new Grass(2, 3);
        grass.setType("test");
        assertEquals("test", grass.getType());
    }
}

