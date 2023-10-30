package WizardTD.Manager;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.*;
import WizardTD.Monster.Beetle;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class FireBallManagerTest {
    FireBallManager fireBallManager = new FireBallManager();
    App app = new App();

    /**
     * Test generate(App) method in FireBallManager.
     */
    @Test
    void testGenerate() throws InterruptedException {
        app.jsonInfo = new JsonInfo("config1.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.paths = new Paths();
        app.towerLevel = new int[3];
        app.waves = new Wave[app.jsonInfo.getWaves().size()];
        for (int i = 0; i < app.jsonInfo.getWaves().size(); i++) {
            app.waves[i] = new Wave(app.jsonInfo.getWaves().getJSONObject(i));
        }
        app.buildMap(App.map, app.paths);
        app.paths.findPaths(app);
        app.monsterManager = new MonsterManager(app);
        app.towers = new ArrayList<>();
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        app.monsterManager.list.add(beetle);
        app.towers.add(new Tower(2, 0, app));
        fireBallManager.generate(app);
        assertEquals(0, fireBallManager.list.size());
        sleep(1500);
        fireBallManager.generate(app);
        assertEquals(1, fireBallManager.list.size());
    }

    /**
     * Test update(App) method in FireBallManager.
     */
    @Test
    void testUpdate() throws InterruptedException {
        app.jsonInfo = new JsonInfo("config1.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.paths = new Paths();
        app.towerLevel = new int[3];
        app.waves = new Wave[app.jsonInfo.getWaves().size()];
        for (int i = 0; i < app.jsonInfo.getWaves().size(); i++) {
            app.waves[i] = new Wave(app.jsonInfo.getWaves().getJSONObject(i));
        }
        app.buildMap(App.map, app.paths);
        app.paths.findPaths(app);
        app.monsterManager = new MonsterManager(app);
        app.towers = new ArrayList<>();
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        app.monsterManager.list.add(beetle);
        app.towers.add(new Tower(2, 0, app));
        fireBallManager.generate(app);
        sleep(1500);
        fireBallManager.generate(app);
        fireBallManager.update(app);
        assertEquals(1, fireBallManager.list.size());
        fireBallManager.update(app);
        fireBallManager.update(app);
        fireBallManager.update(app);
        fireBallManager.update(app);
        fireBallManager.update(app);
        fireBallManager.update(app);
        fireBallManager.update(app);
        fireBallManager.update(app);
        assertEquals(0, fireBallManager.list.size());
    }
}

