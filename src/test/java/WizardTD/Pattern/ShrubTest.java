package WizardTD.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShrubTest {
    /**
     * Method under test: {@link Shrub#Shrub(int, int)}
     */
    @Test
    void testConstructor() {
        Shrub actualShrub = new Shrub(2, 3);
        assertEquals("shrub.png", actualShrub.getType());
        assertEquals(3, actualShrub.getY());
        assertEquals(2, actualShrub.getX());
    }
}

