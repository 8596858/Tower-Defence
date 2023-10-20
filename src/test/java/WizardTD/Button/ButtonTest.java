package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.App;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.core.PGraphics;

class ButtonTest {
    FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 20);
    App app = new App();

    @Test
    void testGetter() {
        assertEquals(2, fasterSpeed.getX());
        assertEquals(3, fasterSpeed.getY());
        assertEquals(20.0f, fasterSpeed.getSize());
        assertEquals(2, fasterSpeed.getStartX());
        assertEquals(22, fasterSpeed.getEndX());
        assertEquals(3, fasterSpeed.getStartY());
        assertEquals(23, fasterSpeed.getEndY());
        assertEquals("2x speed", fasterSpeed.getDescribe());
        assertEquals("FF", fasterSpeed.getLabel());
    }

    @Test
    void testIsUsing() {
        assertFalse(fasterSpeed.isUsing());
        fasterSpeed.setUsing(true);
        assertTrue(fasterSpeed.isUsing());
    }

    @Test
    void testSetUsing() {
        fasterSpeed.setUsing(true);
        assertTrue(fasterSpeed.isUsing());
    }

    @Test
    @Disabled()
    void testDisplayRect() {
        fasterSpeed.displayRect(app);
    }

    @Test
    @Disabled()
    void testDisplayText() {
        fasterSpeed.displayText(new App(), 1);
    }

    @Test
    @Disabled()
    void testDisplayButton() {
        fasterSpeed.displayButton(new App(), 1);
    }
}

