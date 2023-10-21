package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import WizardTD.App;
import org.junit.jupiter.api.Test;

class Level2Test {
    @Test
    void testClickButton() {
        App app = new App();
        Level2 level2 = new Level2(2, 3, 3);
        level2.clickButton(app);
        assertEquals("config2.json", app.configPath);
    }
}

