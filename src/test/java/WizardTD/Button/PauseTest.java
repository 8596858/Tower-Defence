package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.App;
import org.junit.jupiter.api.Test;

class PauseTest {
    /**
     * Test clickButton(App) method in Pause.
     */
    @Test
    void testClickButton() {
        Pause pause = new Pause(1, 1, 2);
        pause.clickButton(new App());
        assertTrue(pause.isUsing());
        assertTrue(App.PAUSE);
    }
}

