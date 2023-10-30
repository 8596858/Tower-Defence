package WizardTD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.Pattern.Path;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PathsTest {
    Paths paths = new Paths();
    static App app = new App();

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
    }

    /**
     * Test if the Paths can be instantiated correctly.
     */
    @Test
    void testConstructor() {
        assertEquals(0, paths.getStartPoints().size());
    }

    /**
     * Test setStartPoints(Path) method in Paths.
     */
    @Test
    void testSetStartPoints() {
        Path path = new Path(2, 3);
        paths.setStartPoints(path);
        assertEquals(1, paths.getStartPoints().size());
    }

    /**
     * Test findPaths(App) method in Paths.
     */
    @Test
    void testFindPaths() {
        paths = new Paths();
        app.jsonInfo = new JsonInfo("test.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.buildMap(App.map, paths);
        paths.findPaths(app);
        assertEquals(76, paths.getStartPoints().size());
    }
}
