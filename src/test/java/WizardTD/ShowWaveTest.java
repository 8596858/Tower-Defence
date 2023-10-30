package WizardTD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.Manager.TextManager;
import org.junit.jupiter.api.Test;

class ShowWaveTest {
    ShowWave showWave = new ShowWave(0, 0, 1, 10.0d);

    /**
     * Test getter methods in ShowWave.
     */
    @Test
    void testGetter() {
        assertEquals(10, showWave.getDuration());
        assertEquals(1, showWave.getSpeed());
    }

    /**
     * Test setter methods in ShowWave.
     */
    @Test
    void testSetter() {
        showWave.setWave(2);
        showWave.setSpeed(2);
        showWave.setDuration(20);
        assertEquals(20, showWave.getDuration());
        assertEquals(2, showWave.getSpeed());
    }

    /**
     * Test addText(App, TextManager) method in ShowWave.
     */
    @Test
    void testAddText() {
        App app = new App();
        app.textManager = new TextManager();
        showWave.addText(app, app.textManager);
        assertEquals(1, app.textManager.getTextList().size());
    }
}

