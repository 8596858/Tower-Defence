package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.App;
import org.junit.jupiter.api.Test;

class PauseTest {
    @Test
    void testClickButton() {
        Pause pause = new Pause(1, 1, 2);
        pause.clickButton(new App());
        assertTrue(pause.isUsing());
        assertTrue(App.PAUSE);
    }
}

