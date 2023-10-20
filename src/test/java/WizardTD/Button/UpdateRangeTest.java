package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UpdateRangeTest {
    App app = new App();

    /**
     * Method under test: {@link UpdateRange#clickButton(App)}
     */
    @Test
    void testClickButton() {
        app.isUpdateTower = new boolean[3];
        app.towerLevel = new int[3];
        UpdateRange updateRange = new UpdateRange(2, 3, 3);
        updateRange.setUsing(false);
        int cost = Tower.TOWER_COST;
        updateRange.clickButton(app);
        assertTrue(updateRange.isUsing());
        assertTrue(app.isUpdateTower[0]);
        assertEquals(Tower.LEVEL_COST[0], Tower.TOWER_COST - cost);
        assertEquals(1, app.towerLevel[0]);
        cost = Tower.TOWER_COST;
        updateRange.clickButton(app);
        assertFalse(updateRange.isUsing());
        assertFalse(app.isUpdateTower[0]);
        assertEquals(Tower.LEVEL_COST[0], cost - Tower.TOWER_COST);
        assertEquals(0, app.towerLevel[0]);
    }
}

