package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.App;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.core.PGraphics;

class ButtonTest {
    @Test
    void testGetEndX() {
        assertEquals(5, (new FasterSpeed(2, 3, 3)).getEndX());
    }

    @Test
    void testGetStartY() {
        assertEquals(3, (new FasterSpeed(2, 3, 3)).getStartY());
    }

    @Test
    void testGetEndY() {
        assertEquals(6, (new FasterSpeed(2, 3, 3)).getEndY());
    }

    @Test
    void testGetDescribe() {
        assertEquals("2x speed", (new FasterSpeed(2, 3, 3)).getDescribe());
    }

    @Test
    void testGetLabel() {
        assertEquals("FF", (new FasterSpeed(2, 3, 3)).getLabel());
    }

    @Test
    void testIsUsing() {
        assertFalse((new FasterSpeed(2, 3, 3)).isUsing());
    }

    @Test
    void testIsUsing2() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.setUsing(true);
        assertTrue(fasterSpeed.isUsing());
    }
}

