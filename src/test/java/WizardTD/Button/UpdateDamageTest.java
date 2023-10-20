package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDamageTest{
    App app = new App();

    /**
     * Method under test: {@link UpdateDamage#clickButton(App)}
     */
    @Test
    void testClickButton() {
        app.isUpdateTower = new boolean[3];
        app.towerLevel = new int[3];
        UpdateDamage updateDamage = new UpdateDamage(2, 3, 3);
        updateDamage.setUsing(false);
        int cost = Tower.TOWER_COST;
        updateDamage.clickButton(app);
        assertTrue(updateDamage.isUsing());
        assertTrue(app.isUpdateTower[2]);
        assertEquals(Tower.LEVEL_COST[0], Tower.TOWER_COST - cost);
        assertEquals(1, app.towerLevel[2]);
        cost = Tower.TOWER_COST;
        updateDamage.clickButton(app);
        assertFalse(updateDamage.isUsing());
        assertFalse(app.isUpdateTower[2]);
        assertEquals(Tower.LEVEL_COST[0], cost - Tower.TOWER_COST);
        assertEquals(0, app.towerLevel[2]);
    }
}

