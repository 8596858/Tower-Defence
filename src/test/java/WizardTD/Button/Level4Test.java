package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import WizardTD.App;
import org.junit.jupiter.api.Test;

class Level4Test {
    /**
     * Method under test: {@link Level4#clickButton(App)}
     */
    @Test
    void testClickButton() {
        App app = new App();
        Level4 level4 = new Level4(2, 3, 3);
        level4.clickButton(app);
        assertEquals("config4.json", app.configPath);
    }
}

