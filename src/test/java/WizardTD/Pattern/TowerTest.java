package WizardTD.Pattern;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
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
     * Method under test: {@link Tower#display(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplay() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.Pattern.Tower.<init>(Tower.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        Tower tower = new Tower(2, 3, new App());
        tower.display(new App());
    }

    /**
     * Method under test: {@link Tower#fillPixels(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFillPixels() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.Pattern.Tower.<init>(Tower.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        Tower tower = new Tower(2, 3, new App());
        tower.fillPixels(new App());
    }

    /**
     * Method under test: {@link Tower#displayRect(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayRect() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.Pattern.Tower.<init>(Tower.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        Tower tower = new Tower(2, 3, new App());
        tower.displayRect(new App());
    }

    /**
     * Method under test: {@link Tower#displayText(App, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayText() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.Pattern.Tower.<init>(Tower.java:35)
        //   See https://diff.blue/R013 to resolve this issue.

        Tower tower = new Tower(2, 3, new App());
        tower.displayText(new App(), 1);
    }
}

