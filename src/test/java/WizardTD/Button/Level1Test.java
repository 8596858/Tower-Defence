package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import WizardTD.App;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

class Level1Test {
    @Test
    void testClickButton() {
        App app = new App();
        Level1 level1 = new Level1(2, 3, 3);
        level1.clickButton(app);
        assertEquals("config1.json", app.configPath);
    }
}

