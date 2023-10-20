package WizardTD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShowWaveTest {
    ShowWave showWave = new ShowWave(0, 0, 1, 10.0d);

    @Test
    void testConstructor() {
        assertEquals(10, showWave.getDuration());
        assertEquals(1, showWave.getSpeed());
    }

    /**
     * Method under test: {@link ShowWave#displayText(App, int)}
     */
    @Test
    void testSetter() {
        showWave.setWave(2);
        showWave.setSpeed(2);
        showWave.setDuration(20);
        assertEquals(20, showWave.getDuration());
        assertEquals(2, showWave.getSpeed());
    }
}

