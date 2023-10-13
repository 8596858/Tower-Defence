package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.App;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FireBallManagerTest {

    @Test
    void testConstructor() {
        assertTrue((new FireBallManager()).list.isEmpty());
    }

    @Test
    void testUpdate() {
        FireBallManager fireBallManager = new FireBallManager();
        App app = new App();
        fireBallManager.update(app);
        assertFalse(app.exitCalled());
        assertEquals(100, app.width);
        assertEquals(4, app.requestImageMax);
        assertEquals(0, app.pmouseY);
        assertEquals(0, app.pmouseX);
        assertEquals(0, app.pixelWidth);
        assertEquals(0, app.pixelHeight);
        assertEquals(1, app.pixelDensity);
        assertEquals(0, app.mouseY);
        assertEquals(0, app.mouseX);
        assertFalse(app.mousePressed);
        assertEquals(0, app.mouseButton);
        assertFalse(app.keyPressed);
        assertEquals(0, app.keyCode);
        assertEquals('\u0000', app.key);
        assertEquals(100, app.height);
        assertEquals(10.0f, app.frameRate);
        assertEquals(0, app.frameCount);
        assertFalse(app.focused);
        assertTrue(app.firstMouse);
        assertFalse(app.finished);
        assertEquals(0, app.displayWidth);
        assertEquals(0, app.displayHeight);
        assertEquals(0.0d, app.currentMana);
        assertEquals("config.json", app.configPath);
        assertFalse(app.canUpdateTower);
        assertTrue(app.isLooping());
        assertTrue(fireBallManager.list.isEmpty());
    }
}

