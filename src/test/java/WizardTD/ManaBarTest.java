package WizardTD;

import WizardTD.Button.ManaPool;
import WizardTD.Monster.Beetle;
import WizardTD.Monster.Monster;
import WizardTD.Pattern.Path;
import WizardTD.Pattern.Tower;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.data.JSONObject;

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
    }

    /**
     * Method under test: {@link ManaBar#ManaBar(int, int, int, String, App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {
        assertEquals(0, manaBar.getX());
        assertEquals(0, manaBar.getY());
        assertEquals(20, manaBar.getWidth());
        assertEquals("", manaBar.getLabel());
        assertEquals(200, manaBar.getProcess());
        assertEquals(2, manaBar.getGainedSpeed());
        assertEquals(1000, manaBar.getManaCap());
    }

    @Test
    void testSetProcess() {
        manaBar.setProcess(300);
        assertEquals(300, manaBar.getProcess());
    }

    /**
     * Method under test: {@link ManaBar#updateProcess(boolean)}
     * Method under test: {@link ManaBar#updateProcess(int)}
     */
    @Test
    void testUpdateProcess() {
        App.IS_ACCELERATE = true;
        manaBar.updateProcess(true);
        assertEquals("200.07", String.format("%.2f", manaBar.getProcess()));
        App.IS_ACCELERATE = true;
        manaBar.updateProcess(true);
        assertEquals("200.13", String.format("%.2f", manaBar.getProcess()));
        manaBar.setProcess(1200);
        manaBar.updateProcess(true);
        assertEquals(1000, manaBar.getProcess());
        manaBar.updateProcess(120);
        assertEquals(880, manaBar.getProcess());
    }

    /**
     * Method under test: {@link ManaBar#beAttacked(Monster)}
     */
    @Test
    void testBeAttacked() {
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        manaBar.beAttacked(beetle);
        assertEquals(100, manaBar.getProcess());
    }

    /**
     * Method under test: {@link ManaBar#addMonsterMana(Monster)}
     */
    @Test
    void testAddMonsterMana() {
        Beetle beetle = new Beetle(app.paths.getStartPoints().get(0), app,
                app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0));
        manaBar.addMonsterMana(beetle);
        assertEquals(210, manaBar.getProcess());
    }

    /**
     * Method under test: {@link ManaBar#updateManaBar(ManaPool)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateManaBar() {
        ManaPool manaPool = new ManaPool(0, 0, 10, app.jsonInfo);
        manaBar.updateManaBar(manaPool);
        assertEquals("2.2", String.format("%.1f", manaBar.getGainedSpeed()));
        assertEquals(1500, manaBar.getManaCap());
        assertEquals(100, manaBar.getProcess());
    }

    /**
     * Method under test: {@link ManaBar#displayRect(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayRect() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.ManaBar.<init>(ManaBar.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        ManaBar manaBar = new ManaBar(2, 3, 1, "Label", new App());
        manaBar.displayRect(new App());
    }

    /**
     * Method under test: {@link ManaBar#displayText(App, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplayText() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.ManaBar.<init>(ManaBar.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        ManaBar manaBar = new ManaBar(2, 3, 1, "Label", new App());
        manaBar.displayText(new App(), 1);
    }

    /**
     * Method under test: {@link ManaBar#display(App, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplay() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.ManaBar.<init>(ManaBar.java:34)
        //   See https://diff.blue/R013 to resolve this issue.

        ManaBar manaBar = new ManaBar(2, 3, 1, "Label", new App());
        manaBar.display(new App(), 1);
    }
}

