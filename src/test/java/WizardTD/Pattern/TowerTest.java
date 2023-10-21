package WizardTD.Pattern;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.TextManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TowerTest {
    static App app = new App();
    Tower tower = new Tower(0, 0, app);

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.towerLevel = new int[3];
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.shapeManager = new ShapeManager();
        app.textManager = new TextManager();
        app.isUpdateTower = new boolean[3];
        app.isUpdateTower[0] = true;
        app.isUpdateTower[1] = true;
        app.isUpdateTower[2] = true;
    }

    /**
     * Method under test: {@link Tower#Tower(int, int, App)}
     */
    @Test
    void testConstructor() {
        assertEquals("tower0.png", tower.getType());
        assertEquals(40, tower.getDamage());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Tower#setTimer(long)}
     *   <li>{@link Tower#setAccelerate()}
     * </ul>
     */
    @Test
    void testSetter() {
        tower.setTimer(20);
        assertEquals(20, tower.getTimer());
        App.IS_ACCELERATE = false;
        tower.setAccelerate();
        assertEquals(0.75d, tower.getFiringSpeed());
        App.IS_ACCELERATE = true;
        tower.setAccelerate();
        assertEquals(1.5d, tower.getFiringSpeed());
    }

    /**
     * Method under test: {@link Tower#updateLevel(boolean[], App)}
     */
    @Test
    void testUpdateLevel() {
        tower = new Tower(0, 0, app);
        app.manaBar.setProcess(1000);
        tower.updateLevel(app.isUpdateTower, app);
        assertEquals(940, app.manaBar.getProcess());
        assertEquals(128, tower.getRange());
        assertEquals(2, tower.getFiringSpeed());
        assertEquals(60, tower.getDamage());
        assertEquals("tower1.png", tower.getType());
        tower.updateLevel(app.isUpdateTower, app);
        assertEquals(850, app.manaBar.getProcess());
        assertEquals(160, tower.getRange());
        assertEquals(2.5, tower.getFiringSpeed());
        assertEquals(80, tower.getDamage());
        assertEquals("tower2.png", tower.getType());
        tower.updateLevel(app.isUpdateTower, app);
        assertEquals(730, app.manaBar.getProcess());
        assertEquals(192, tower.getRange());
        assertEquals(3, tower.getFiringSpeed());
        assertEquals(100, tower.getDamage());
    }

    /**
     * Method under test: {@link Tower#display(App, ShapeManager, TextManager)}
     */
    @Test
    void testDisplay() {
        tower.display(app, app.shapeManager, app.textManager);
        assertEquals(4, app.shapeManager.getShapeList().size());
        assertEquals(5, app.textManager.getTextList().size());
    }

    /**
     * Method under test: {@link Tower#fillPixels(ShapeManager)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFillPixels() {
        app.manaBar.setProcess(1000);
        tower.updateLevel(app.isUpdateTower, app);
        tower.updateLevel(app.isUpdateTower, app);
        tower.updateLevel(app.isUpdateTower, app);
        tower.fillPixels(app.shapeManager);
        assertEquals(9, app.shapeManager.getShapeList().size());
    }
}

