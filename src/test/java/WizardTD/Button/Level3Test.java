package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import WizardTD.App;
import org.junit.jupiter.api.Test;

class Level3Test {
    /**
     * Method under test: {@link Level3#clickButton(App)}
     */
    @Test
    void testClickButton() {
        App app = new App();
        Level3 level3 = new Level3(2, 3, 3);
        level3.clickButton(app);
        assertEquals("config3.json", app.configPath);
    }
}

