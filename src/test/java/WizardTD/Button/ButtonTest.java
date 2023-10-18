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
    void testGetX() {
        assertEquals(2, (new FasterSpeed(2, 3, 3)).getX());
    }

    @Test
    void testGetY() {
        assertEquals(3, (new FasterSpeed(2, 3, 3)).getY());
    }

    @Test
    void testGetSize() {
        assertEquals(3.0f, (new FasterSpeed(2, 3, 3)).getSize());
    }

    @Test
    void testGetStartX() {
        assertEquals(2, (new FasterSpeed(2, 3, 3)).getStartX());
    }

    @Test
    void testGetEndX() {
        assertEquals(5, (new FasterSpeed(2, 3, 3)).getEndX());
        assertEquals(5, (new FasterSpeed(2, 3, 3)).getEndX());
    }

    @Test
    void testGetStartY() {
        assertEquals(3, (new FasterSpeed(2, 3, 3)).getStartY());
        assertEquals(3, (new FasterSpeed(2, 3, 3)).getStartY());
    }

    @Test
    void testGetEndY() {
        assertEquals(6, (new FasterSpeed(2, 3, 3)).getEndY());
        assertEquals(6, (new FasterSpeed(2, 3, 3)).getEndY());
    }

    @Test
    void testGetDescribe() {
        assertEquals("2x speed", (new FasterSpeed(2, 3, 3)).getDescribe());
        assertEquals("2x speed", (new FasterSpeed(2, 3, 3)).getDescribe());
    }

    @Test
    void testGetLabel() {
        assertEquals("FF", (new FasterSpeed(2, 3, 3)).getLabel());
        assertEquals("FF", (new FasterSpeed(2, 3, 3)).getLabel());
    }

    @Test
    void testIsUsing() {
        assertFalse((new FasterSpeed(2, 3, 3)).isUsing());
        assertFalse((new FasterSpeed(2, 3, 3)).isUsing());
    }

    @Test
    void testIsUsing2() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.setUsing(true);
        assertTrue(fasterSpeed.isUsing());
    }

    @Test
    void testIsUsing3() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.setUsing(true);
        assertTrue(fasterSpeed.isUsing());
    }

    @Test
    void testSetUsing() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.setUsing(true);
        assertTrue(fasterSpeed.isUsing());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayRect() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.displayRect(new App());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayRect2() {

        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);

        App app = new App();
        app.beginRecord(new PGraphics());
        fasterSpeed.displayRect(app);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayText() {

        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.displayText(new App(), 1);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayText2() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);

        App app = new App();
        app.beginRecord(new PGraphics());
        fasterSpeed.displayText(app, 1);
    }
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayButton() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.displayButton(new App(), 1);
    }
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayButton2() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);

        App app = new App();
        app.beginRecord(new PGraphics());
        fasterSpeed.displayButton(app, 1);
    }
}

