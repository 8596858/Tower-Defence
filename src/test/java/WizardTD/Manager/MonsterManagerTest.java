package WizardTD.Manager;

import WizardTD.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MonsterManagerTest {
    App app = new App();

    /**
     * Test generate(App) method in MonsterManager.
     */
    @Test
    void testGenerate() throws InterruptedException {
        app.jsonInfo = new JsonInfo("config1.json");
        App.map = app.mapInfo(app.jsonInfo);
        App.WAVE_INDEX = -1;
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.showWave = new ShowWave(0, 0, 0, 0);
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
        MonsterManager monsterManager = new MonsterManager(app);
        monsterManager.generate(app);
        sleep(1500);
        monsterManager.generate(app);
        assertEquals(1, monsterManager.getMonsters().size());
    }

    /**
     * Test setAccelerate() method in MonsterManager.
     */
    @Test
    void testSetAccelerate() throws InterruptedException {
        app.jsonInfo = new JsonInfo("config1.json");
        App.map = app.mapInfo(app.jsonInfo);
        App.WAVE_INDEX = -1;
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.showWave = new ShowWave(0, 0, 0, 0);
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
        MonsterManager monsterManager = new MonsterManager(app);
        monsterManager.generate(app);
        sleep(1500);
        monsterManager.generate(app);
        App.IS_ACCELERATE = true;
        monsterManager.setAccelerate();
        assertEquals(2, monsterManager.getMonsters().get(0).getSpeed());
    }

    /**
     * Test update(App) method in MonsterManager.
     */
    @Test
    void testUpdate() throws InterruptedException {
        app.jsonInfo = new JsonInfo("config1.json");
        App.map = app.mapInfo(app.jsonInfo);
        App.WAVE_INDEX = -1;
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.showWave = new ShowWave(0, 0, 0, 0);
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
        MonsterManager monsterManager = new MonsterManager(app);
        monsterManager.generate(app);
        sleep(1500);
        monsterManager.generate(app);
        monsterManager.getMonsters().get(0).setHp(112);
        monsterManager.update(app);
        assertTrue(monsterManager.getMonsters().get(0).isDie());
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        monsterManager.update(app);
        assertEquals(0, monsterManager.getMonsters().size());
    }
}

