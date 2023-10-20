package WizardTD.Pattern;

import WizardTD.App;

import java.util.ArrayList;

import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import WizardTD.Paths;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
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
     * Method under test: {@link Path#Path(int, int)}
     */
    @Test
    void testConstructor() {
        assertEquals(0, path.getParent().size());
        assertEquals(0, path.getLength());
        assertEquals(0, path.getDirection().size());
    }

    /**
     * Method under test: {@link Path#setParent(Path)}
     */
    @Test
    void testSetParent() {
        path.setParent(new Path(2, 2));
        assertEquals(1, path.getParent().size());
    }

    /**
     * Method under test: {@link Path#clearParent()}
     */
    @Test
    void testClearParent() {
        path.clearParent();
        assertEquals(0, path.getParent().size());
    }

    /**
     * Method under test: {@link Path#setDirection(int)}
     */
    @Test
    void testSetDirection() {
        path.setDirection(0);
        assertEquals(1, path.getDirection().size());
    }

    /**
     * Method under test: {@link Path#clearDirection()}
     */
    @Test
    void testClearDirection() {
        path.clearDirection();
        assertEquals(0, path.getDirection().size());
    }

    /**
     * Method under test: {@link Path#setLength(int)}
     */
    @Test
    void testSetLength() {
        path.setLength(1);
        assertEquals(1, path.getLength());
    }

    /**
     * Method under test: {@link Path#calculatePathAngle(char[][], int, int)}
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

