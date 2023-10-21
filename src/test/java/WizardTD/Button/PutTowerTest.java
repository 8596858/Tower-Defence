package WizardTD.Button;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.TextManager;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PutTowerTest {
    @Test
    void testDisplay() {
        PutTower putTower = new PutTower(1, 1, 1);
        ShapeManager shapeManager = new ShapeManager();
        TextManager textManager = new TextManager();
        putTower.display(shapeManager, textManager);
        assertEquals(1, shapeManager.getShapeList().size());
        assertEquals(1, textManager.getTextList().size());
    }

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

