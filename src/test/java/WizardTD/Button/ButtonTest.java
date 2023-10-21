package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.App;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.TextManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    void testDisplayText() {
        app.textManager = new TextManager();
        fasterSpeed.addText(app, app.textManager);
        assertEquals(2, app.textManager.getTextList().size());
    }
}

