package WizardTD;

import WizardTD.Button.ManaPool;
import WizardTD.Monster.Beetle;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.TextManager;
import WizardTD.Pattern.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManaBarTest {
    ManaBar manaBar = new ManaBar(0, 0, 20, "", app);
    static App app = new App();

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.paths = new Paths();
        app.paths.setStartPoints(new Path(0, 0));
        app.shapeManager = new ShapeManager();
        app.textManager = new TextManager();
    }

    /**
     * Test getter methods in ManaBar.
     */
    @Test
    void testGetter() {
        assertEquals(0, manaBar.getX());
        assertEquals(0, manaBar.getY());
        assertEquals(2, manaBar.getGainedSpeed());
        assertEquals(1000, manaBar.getManaCap());
        assertEquals(20, manaBar.getWidth());
        assertEquals(200, manaBar.getProcess());
        assertEquals("", manaBar.getLabel());
    }

    /**
     * Test setProcess(float) method in ManaBar.
     */
    @Test
    void testSetProcess() {
        manaBar.setProcess(300);
        assertEquals(300, manaBar.getProcess());
    }

    /**
     * Test updateProcess(boolean) method in ManaBar.
     */
    @Test
    void testUpdateProcess() {
        App.IS_ACCELERATE = true;
        manaBar.updateProcess(true);
        assertEquals("200.07", String.format("%.2f", manaBar.getProcess()));
        App.IS_ACCELERATE = false;
        manaBar.updateProcess(true);
        assertEquals("200.10", String.format("%.2f", manaBar.getProcess()));
        manaBar.setProcess(1200);
        manaBar.updateProcess(true);
        assertEquals(1000, manaBar.getProcess());
        manaBar.updateProcess(120);
        assertEquals(880, manaBar.getProcess());
    }

    /**
     * Test beAttacked(Monster) method in ManaBar.
     */
    @Test
    void testBeAttacked() {
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        manaBar.beAttacked(beetle);
        assertEquals(100, manaBar.getProcess());
    }

    /**
     * Test addMonsterMana(Monster) method in ManaBar.
     */
    @Test
    void testAddMonsterMana() {
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        manaBar.addMonsterMana(beetle);
        assertEquals(210, manaBar.getProcess());
    }

    /**
     * Test updateManaBar(ManaPool) method in ManaBar.
     */
    @Test
    void testUpdateManaBar() {
        ManaPool manaPool = new ManaPool(0, 0, 10, app.jsonInfo);
        manaBar.updateManaBar(manaPool);
        assertEquals("2.2", String.format("%.1f", manaBar.getGainedSpeed()));
        assertEquals(1500, manaBar.getManaCap());
        assertEquals(100, manaBar.getProcess());
    }

    /**
     * Test display(App, ShapeManager, TextManager) method in ManaBar.
     */
    @Test
    void testDisplay() {
        manaBar.display(app, app.shapeManager, app.textManager);
        assertEquals(2, app.shapeManager.getShapeList().size());
        assertEquals(2, app.textManager.getTextList().size());
    }
}

