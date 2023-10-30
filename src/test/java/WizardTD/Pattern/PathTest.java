package WizardTD.Pattern;

import WizardTD.App;
import WizardTD.JsonInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PathTest {
    static App app = new App();
    Path path = new Path(0, 0);

    @BeforeAll
    public static void setUp() {
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
    }

    /**
     * Test getter methods in Path.
     */
    @Test
    void testGetter() {
        assertEquals(0, path.getParent().size());
        assertEquals(0, path.getLength());
        assertEquals(0, path.getDirection().size());
    }

    /**
     * Test setParent(Path) method in Path.
     */
    @Test
    void testSetParent() {
        path.setParent(new Path(2, 2));
        assertEquals(1, path.getParent().size());
    }

    /**
     * Test clearParent() method in Path.
     */
    @Test
    void testClearParent() {
        path.clearParent();
        assertEquals(0, path.getParent().size());
    }

    /**
     * Test setDirection(int) method in Path.
     */
    @Test
    void testSetDirection() {
        path.setDirection(0);
        assertEquals(1, path.getDirection().size());
    }

    /**
     * Test clearDirection() method in Path.
     */
    @Test
    void testClearDirection() {
        path.clearDirection();
        assertEquals(0, path.getDirection().size());
    }

    /**
     * Test setLength(int) method in Path.
     */
    @Test
    void testSetLength() {
        path.setLength(1);
        assertEquals(1, path.getLength());
    }

    /**
     * Test setType(String) and calculatePathAngle(char[][], int, int) method in Path.
     */
    @Test
    void testCalculatePathAngle() {
        path = new Path(5, 10);
        path.setType("path");
        assertEquals("path1.png", path.getType());
        path = new Path(8, 16);
        path.setType("path");
        assertEquals("path1.png", path.getType());
        path = new Path(17, 6);
        path.setType("path");
        assertEquals("path1.png", path.getType());
        path = new Path(17, 14);
        path.setType("path");
        assertEquals("path1.png", path.getType());
        path = new Path(8, 10);
        path.setType("path");
        assertEquals("path3.png", path.getType());
        path = new Path(0, 16);
        path.setType("path");
        assertEquals("path0.png", path.getType());
        path = new Path(2, 16);
        path.setType("path");
        assertEquals("path0.png", path.getType());
        path = new Path(5, 19);
        path.setType("path");
        assertEquals("path0.png", path.getType());
        path = new Path(5, 18);
        path.setType("path");
        assertEquals("path0.png", path.getType());
        path = new Path(7, 16);
        path.setType("path");
        assertEquals("path2.png", path.getType());
        path = new Path(8, 15);
        path.setType("path");
        assertEquals("path2.png", path.getType());
        path = new Path(1, 16);
        path.setType("path");
        assertEquals("path2.png", path.getType());
        app.jsonInfo = new JsonInfo("config4.json");
        App.map = app.mapInfo(app.jsonInfo);
        path = new Path(8, 10);
        path.setType("path");
        assertEquals("path2.png", path.getType());
    }
}

