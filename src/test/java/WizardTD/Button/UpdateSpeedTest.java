package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UpdateSpeedTest {
    App app = new App();

    /**
     * Test clickButton(App) method in UpdateSpeed.
     */
    @Test
    void testClickButton() {
        app.isUpdateTower = new boolean[3];
        app.towerLevel = new int[3];
        UpdateSpeed updateSpeed = new UpdateSpeed(2, 3, 3);
        updateSpeed.setUsing(false);
        int cost = Tower.TOWER_COST;
        updateSpeed.clickButton(app);
        assertTrue(updateSpeed.isUsing());
        assertTrue(app.isUpdateTower[1]);
        assertEquals(Tower.LEVEL_COST[0], Tower.TOWER_COST - cost);
        assertEquals(1, app.towerLevel[1]);
        cost = Tower.TOWER_COST;
        updateSpeed.clickButton(app);
        assertFalse(updateSpeed.isUsing());
        assertFalse(app.isUpdateTower[1]);
        assertEquals(Tower.LEVEL_COST[0], cost - Tower.TOWER_COST);
        assertEquals(0, app.towerLevel[1]);
    }
}

