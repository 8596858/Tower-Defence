package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class Level1Test {
    @Test
    void testConstructor() {
        Level1 actualLevel1 = new Level1(2, 3, 3);

        assertEquals("", actualLevel1.getDescribe());
        assertFalse(actualLevel1.isUsing());
        assertEquals(3, actualLevel1.getY());
        assertEquals(2, actualLevel1.getX());
        assertEquals(3, actualLevel1.getStartY());
        assertEquals(2, actualLevel1.getStartX());
        assertEquals(3.0f, actualLevel1.getSize());
        assertEquals("1", actualLevel1.getLabel());
        assertEquals(6, actualLevel1.getEndY());
        assertEquals(5, actualLevel1.getEndX());
    }
}

