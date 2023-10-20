package WizardTD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.Pattern.Path;
import WizardTD.Pattern.Pattern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PathsTest {
    Paths paths = new Paths();
    static App app = new App();

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
    }

    @Test
    void testConstructor() {
        assertEquals(0, paths.getStartPoints().size());
    }

    /**
     * Method under test: {@link Paths#setStartPoints(Path)}
     */
    @Test
    void testSetStartPoints() {
        Path path = new Path(2, 3);
        paths.setStartPoints(path);
        assertEquals(1, paths.getStartPoints().size());
    }

    /**
     * Method under test: {@link Paths#findPaths(App)}
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
