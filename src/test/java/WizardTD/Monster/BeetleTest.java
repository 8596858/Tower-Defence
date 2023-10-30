package WizardTD.Monster;

import WizardTD.*;
import WizardTD.Pattern.Path;
import WizardTD.Pattern.WizardHouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeetleTest{
    static App app = new App();

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.paths = new Paths();
        app.paths.setStartPoints(new Path(0, 0));
        app.paths.getStartPoints().get(0).setParent(new Path(1, 0));
        app.paths.getStartPoints().get(0).getParent().get(0).setDirection(0);
        app.paths.getStartPoints().get(0).setDirection(0);
        app.paths.setStartPoints(new Path(1, 0));
        app.paths.getStartPoints().get(1).setParent(new Path(0, 0));
        app.paths.getStartPoints().get(1).getParent().get(0).setDirection(1);
        app.paths.getStartPoints().get(1).setDirection(1);
        app.paths.setStartPoints(new Path(0, 0));
        app.paths.getStartPoints().get(2).setParent(new Path(0, 1));
        app.paths.getStartPoints().get(2).getParent().get(0).setDirection(2);
        app.paths.getStartPoints().get(2).setDirection(2);
        app.paths.setStartPoints(new Path(0, 1));
        app.paths.getStartPoints().get(3).setParent(new Path(0, 0));
        app.paths.getStartPoints().get(3).getParent().get(0).setDirection(3);
        app.paths.getStartPoints().get(3).setDirection(3);
        app.wizardHouse = new WizardHouse(2, 0);
    }

    /**
     * Test if the Beetle can be instantiated correctly.
     */
    @Test
    void testConstructor() {
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        assertEquals("beetle.png", beetle.getType());
        assertEquals(8, beetle.getX());
        assertEquals(0, beetle.getY());
    }

    /**
     * Test monsterDie(App) method in Beetle.
     */
    @Test
    void testMonsterDie() {
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        assertFalse(beetle.monsterDie(app));
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        assertEquals("beetle1.png", beetle.type);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        beetle.monsterDie(app);
        assertTrue(beetle.monsterDie(app));
    }

    /**
     * Test move(App) method in Beetle.
     */
    @Test
    void testMove() {
        App.IS_ACCELERATE = false;
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.move(app);
        assertEquals("beetle2.png", beetle.getType());
        beetle.x = 72;
        beetle.move(app);
        assertEquals("beetle2.png", beetle.getType());
        beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.x = 72;
        app.paths.getStartPoints().get(0).clearParent();
        beetle.move(app);
        assertEquals("beetle2.png", beetle.getType());
        assertEquals(9, beetle.x);
        assertEquals(0, beetle.y);
        beetle = new Beetle(app.paths.getStartPoints().get(1), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.x = 40;
        beetle.move(app);
        assertEquals("beetle.png", beetle.getType());
        beetle = new Beetle(app.paths.getStartPoints().get(1), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.x = 40;
        app.paths.getStartPoints().get(1).clearParent();
        beetle.move(app);
        assertEquals("beetle.png", beetle.getType());
        assertEquals(71, beetle.x);
        assertEquals(-32, beetle.y);
        beetle = new Beetle(app.paths.getStartPoints().get(2), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.y = 32;
        beetle.move(app);
        assertEquals("beetle1.png", beetle.getType());
        beetle = new Beetle(app.paths.getStartPoints().get(2), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.y = 32;
        app.paths.getStartPoints().get(2).clearParent();
        beetle.move(app);
        assertEquals("beetle1.png", beetle.getType());
        assertEquals(8, beetle.x);
        assertEquals(1, beetle.y);
        beetle = new Beetle(app.paths.getStartPoints().get(3), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.y = 0;
        beetle.move(app);
        assertEquals("beetle3.png", beetle.getType());
        beetle = new Beetle(app.paths.getStartPoints().get(3), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        beetle.y = 0;
        app.paths.getStartPoints().get(3).clearParent();
        beetle.move(app);
        assertEquals("beetle3.png", beetle.getType());
        assertEquals(8, beetle.x);
        assertEquals(31, beetle.y);
    }
}

