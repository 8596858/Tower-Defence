package WizardTD;

import WizardTD.Monster.Beetle;
import WizardTD.Monster.Monster;
import WizardTD.Pattern.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.data.JSONObject;

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
     * Method under test: {@link FireBall#FireBall(float, float, double, Monster)}
     */
    @Test
    void testConstructor() {
        assertFalse(fireBall.isFinish());
    }

    /**
     * Method under test: {@link FireBall#setAccelerate()}
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
     * Method under test: {@link FireBall#draw(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDraw() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at WizardTD.Pattern.Path.calculatePathAngle(Path.java:123)
        //       at WizardTD.Pattern.Path.setType(Path.java:81)
        //       at WizardTD.Pattern.Pattern.<init>(Pattern.java:37)
        //       at WizardTD.Pattern.Path.<init>(Path.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        App app = new App();
        Path path = new Path(2, 3);

        JSONObject jsonObject = JSONObject.parse("Source");
        FireBall fireBall = new FireBall(10.0f, 10.0f, 10.0d, new Beetle(path, new App(), jsonObject));
        fireBall.draw(new App());
    }

    /**
     * Method under test: {@link FireBall#move(App)}
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

