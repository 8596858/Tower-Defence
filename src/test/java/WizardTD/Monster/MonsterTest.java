package WizardTD.Monster;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import WizardTD.Manager.ShapeManager;
import WizardTD.Paths;
import WizardTD.Pattern.Path;
import WizardTD.Pattern.WizardHouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import processing.core.PImage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterTest {
    Monster monster = new Gremlin(app.paths.getStartPoints().get(0), app,
            app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
    static App app = new App();
    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.shapeManager = new ShapeManager();
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
        app.paths.setStartPoints(new Path(19, 0));
        app.paths.setStartPoints(new Path(0, 10));
        app.wizardHouse = new WizardHouse(2, 0);
    }

    /**
     * Test if the Monster can be instantiated correctly.
     */
    @Test
    void testConstructor() {
        assertEquals("gremlin.png", monster.getType());
        assertEquals(8, monster.getX());
        assertEquals(0, monster.getY());
        assertEquals(2, monster.getSpeed());
        monster = new Gremlin(app.paths.getStartPoints().get(1), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster = new Gremlin(app.paths.getStartPoints().get(4), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster = new Gremlin(app.paths.getStartPoints().get(5), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
    }

    /**
     * Test setDie(boolean) method in Monster.
     */
    @Test
    void testSetDie() {
        monster.setDie(true);
        assertTrue(monster.isDie());
    }

    /**
     * Test setHp(int) method in Monster.
     */
    @Test
    void testSetHP() {
        monster.setHp(10);
        assertEquals(95, monster.getHp());
    }

    /**
     * Test setAccelerate() method in Monster.
     */
    @Test
    void testSetAccelerate() {
        App.IS_ACCELERATE = false;
        monster.setAccelerate();
        assertEquals(0.5, monster.getSpeed());
        App.IS_ACCELERATE = true;
        monster.setAccelerate();
        assertEquals(1, monster.getSpeed());
    }

    /**
     * Test getTopHp() method in Monster.
     */
    @Test
    void testGetTopHP() {
        assertEquals(100, monster.getTopHp());
    }

    /**
     * Test getManaGainedOnKill() method in Monster.
     */
    @Test
    void testGetManaGainedOnKill() {
        assertEquals(10, monster.getManaGainedOnKill());
    }

    /**
     * Test move(App) method in Monster.
     */
    @Test
    void testMove() {
        App.IS_ACCELERATE = false;
        monster = new Gremlin(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.x = 72;
        monster.move(app);
        monster = new Gremlin(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.x = 72;
        app.paths.getStartPoints().get(0).clearParent();
        monster.move(app);
        assertEquals(9, monster.x);
        assertEquals(0, monster.y);
        monster = new Gremlin(app.paths.getStartPoints().get(1), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.x = 40;
        monster.move(app);
        monster = new Gremlin(app.paths.getStartPoints().get(1), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.x = 40;
        app.paths.getStartPoints().get(1).clearParent();
        monster.move(app);
        assertEquals(71, monster.x);
        assertEquals(-32, monster.y);
        monster = new Gremlin(app.paths.getStartPoints().get(2), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.y = 32;
        monster.move(app);
        monster = new Gremlin(app.paths.getStartPoints().get(2), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.y = 32;
        app.paths.getStartPoints().get(2).clearParent();
        monster.move(app);
        assertEquals(8, monster.x);
        assertEquals(1, monster.y);
        monster = new Gremlin(app.paths.getStartPoints().get(3), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.y = 0;
        monster.move(app);
        monster = new Gremlin(app.paths.getStartPoints().get(3), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        monster.y = 0;
        app.paths.getStartPoints().get(3).clearParent();
        monster.move(app);
        assertEquals(8, monster.x);
        assertEquals(31, monster.y);
    }

    /**
     * Test monsterDie(App) method in Monster.
     */
    @Test
    void testMonsterDie() {
        assertFalse(monster.monsterDie(app));
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        assertEquals("gremlin1.png", monster.type);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        monster.monsterDie(app);
        assertTrue(monster.monsterDie(app));
    }

    /**
     * Test addShape(App, ShapeManager) method in Monster.
     */
    @Test
    void testAddShape() {
        monster.image = new PImage();
        monster.addShape(app, app.shapeManager);
        assertEquals(2, app.shapeManager.getShapeList().size());
    }
}
