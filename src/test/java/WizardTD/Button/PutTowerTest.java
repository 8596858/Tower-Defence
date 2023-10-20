package WizardTD.Button;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PutTowerTest {
    /**
     * Method under test: {@link PutTower#display(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplay() {
        PutTower putTower = new PutTower(1, 1, 1);
        putTower.display(new App());
    }

    /**
     * Method under test: {@link PutTower#clickButton(App)}
     */
    @Test
    void testClickButton() {
        PutTower putTower = new PutTower(1, 1, 1);
        App app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        app.manaBar = new ManaBar(1, 1,1, "", app);
        putTower.setUsing(true);
        putTower.clickButton(app);
        assertFalse(putTower.isUsing());
        assertFalse(App.CAN_BUILD_TOWER);
        Tower.TOWER_COST = 100;
        putTower.clickButton(app);
        assertTrue(putTower.isUsing());
        assertTrue(App.CAN_BUILD_TOWER);
    }
}

