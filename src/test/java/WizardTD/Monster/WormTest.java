package WizardTD.Monster;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import WizardTD.Paths;
import WizardTD.Pattern.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WormTest {
    /**
     * Test monsterDie(App) method in Worm.
     */
    @Test
    void testMonsterDie() {
        App app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.paths = new Paths();
        app.paths.setStartPoints(new Path(0, 0));
        Worm worm = new Worm(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        assertFalse(worm.monsterDie(app));
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        assertEquals("worm1.png", worm.type);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        worm.monsterDie(app);
        assertTrue(worm.monsterDie(app));
    }
}

