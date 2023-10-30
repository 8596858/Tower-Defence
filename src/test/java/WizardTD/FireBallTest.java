package WizardTD;

import WizardTD.Monster.Beetle;
import WizardTD.Pattern.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireBallTest {
    static App app = new App();
    FireBall fireBall = new FireBall(0, 0, 40,
            new Beetle(app.paths.getStartPoints().get(0), app, app.jsonInfo.getWaves().getJSONObject(0).getJSONArray("monsters").getJSONObject(0)));

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.manaBar = new ManaBar(0, 0, 0, "", app);
        app.paths = new Paths();
        app.paths.setStartPoints(new Path(1, 0));
        app.paths.getStartPoints().get(0).setParent(new Path(1, 0));
        app.paths.getStartPoints().get(0).getParent().get(0).setDirection(0);
        app.paths.getStartPoints().get(0).setDirection(0);
    }

    /**
     * Test if the FireBall can be instantiated correctly.
     */
    @Test
    void testConstructor() {
        assertFalse(fireBall.isFinish());
    }

    /**
     * Test setAccelerate() method in FireBall.
     */
    @Test
    void testSetAccelerate() {
        App.IS_ACCELERATE = true;
        FireBall.setAccelerate();
        assertEquals(10f, FireBall.SPEED);
        App.IS_ACCELERATE = false;
        FireBall.setAccelerate();
        assertEquals(5f, FireBall.SPEED);
    }

    /**
     * Test move(App) method in FireBall.
     */
    @Test
    void testMove() {
        fireBall.move(app);
        fireBall.move(app);
        fireBall.move(app);
        fireBall.move(app);
        fireBall.move(app);
        fireBall.move(app);
        fireBall.move(app);
        fireBall.move(app);
        assertTrue(fireBall.isFinish());
    }
}

