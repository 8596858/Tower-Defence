package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class Level2Test {
    @Test
    void testConstructor() {
        Level2 actualLevel2 = new Level2(2, 3, 3);

        assertEquals("", actualLevel2.getDescribe());
        assertFalse(actualLevel2.isUsing());
        assertEquals(3, actualLevel2.getY());
        assertEquals(2, actualLevel2.getX());
        assertEquals(3, actualLevel2.getStartY());
        assertEquals(2, actualLevel2.getStartX());
        assertEquals(3.0f, actualLevel2.getSize());
        assertEquals("2", actualLevel2.getLabel());
        assertEquals(6, actualLevel2.getEndY());
        assertEquals(5, actualLevel2.getEndX());
    }
}

