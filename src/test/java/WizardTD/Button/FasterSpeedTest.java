package WizardTD.Button;

import WizardTD.*;
import WizardTD.Manager.MonsterManager;
import WizardTD.Monster.Monster;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FasterSpeedTest {
    /**
     * Test clickButton(App) method in FasterSpeed.
     */
    @Test
    void testClickButton() {
        App app = new App();
        App.IS_ACCELERATE = false;
        JsonInfo jsonInfo = new JsonInfo("config.json");
        app.waves = new Wave[1];
        app.waves[0] = new Wave(jsonInfo.getWaves().getJSONObject(0));
        app.showWave = new ShowWave(1, 1, 3, 10);
        app.monsterManager = new MonsterManager(app);
        app.towers = new ArrayList<>();
        FasterSpeed fasterSpeed = new FasterSpeed(1, 1, 1);
        double interval = Monster.TIME_INTERVAL;
        fasterSpeed.clickButton(app);
        assertTrue(fasterSpeed.isUsing());
        assertTrue(App.IS_ACCELERATE);
        assertEquals(10, FireBall.SPEED);
        assertEquals(interval / 2, Monster.TIME_INTERVAL);
        assertEquals(2, app.showWave.getSpeed());
        interval = Monster.TIME_INTERVAL;
        fasterSpeed.clickButton(app);
        assertFalse(fasterSpeed.isUsing());
        assertEquals(5, FireBall.SPEED);
        assertEquals(interval, Monster.TIME_INTERVAL);
        assertEquals(1, app.showWave.getSpeed());
    }
}

