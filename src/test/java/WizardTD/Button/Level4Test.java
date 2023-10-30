package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.App;
import org.junit.jupiter.api.Test;

class Level4Test {
    /**
     * Test clickButton(App) method in Level4.
     */
    @Test
    void testClickButton() {
        App app = new App();
        Level4 level4 = new Level4(2, 3, 3);
        level4.clickButton(app);
        assertEquals("config4.json", app.configPath);
    }
}

