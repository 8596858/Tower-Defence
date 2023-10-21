package WizardTD.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.App;
import WizardTD.JsonInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class WizardHouseTest {
    @Test
    void testGetter() {
        WizardHouse wizardHouse = new WizardHouse(1, 1);
        assertEquals("wizard_house.png", wizardHouse.getType());
        assertEquals(1, wizardHouse.getX());
        assertEquals(1, wizardHouse.getY());
    }

    @Test
    void testCalculateHouseAngle() {
        WizardHouse wizardHouse = new WizardHouse(13, 6);
        App app = new App();
        char[][] map = app.mapInfo(new JsonInfo("config.json"));
        assertEquals(3, wizardHouse.calculateHouseAngle(map, wizardHouse.getX(), wizardHouse.getY()));
    }
}

