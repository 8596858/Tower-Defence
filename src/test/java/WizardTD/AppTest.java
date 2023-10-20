package WizardTD;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import WizardTD.Button.Button;
import WizardTD.Button.ButtonList;
import WizardTD.Button.FasterSpeed;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.awt.PGraphicsJava2D;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

class AppTest {
    App app;
    /**
     * Method under test: default or parameterless constructor of {@link App}
     */
    @Test
    void testConstructor() {
        app = new App();
    }

    /**
     * Method under test: {@link App#mapInfo(JsonInfo)}
     */
    @Test
    void testMapInfo() {
        app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
    }

    /**
     * Method under test: {@link App#buildMap(char[][], Paths)}
     */
    @Test
    void testBuildMap() {
        app = new App();
        app.paths = new Paths();
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.buildMap(App.map, app.paths);
    }

    /**
     * Method under test: {@link App#mouseInMap()}
     */
    @Test
    void testMouseInMap() {
        app = new App();
        assertFalse(app.mouseInMap());
    }

    /**
     * Method under test: {@link App#mouseInButton(Button[])}
     */
    @Test
    void testMouseInButton() {
        app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        ButtonList buttonList = new ButtonList(app.jsonInfo);
        App.IN_MENU = true;
        assertEquals(-1, app.mouseInButton(buttonList.getButtons()));
        App.IN_MENU = false;
        assertEquals(-1, app.mouseInButton(buttonList.getButtons()));
    }

    /**
     * Method under test: {@link App#patternCoordinate(int, int)}
     */
    @Test
    void testPatternCoordinate() {
        app = new App();
        assertArrayEquals(new int[]{1, 1}, app.patternCoordinate(72, 32));
    }

    /**
     * Method under test: {@link App#rotateImageByDegrees(PImage, double)}
     */
    @Test
    void testRotateImageByDegrees() {
        App app = new App();
        PImage pimg = new PImage(1, 1);

        PImage actualRotateImageByDegreesResult = app.rotateImageByDegrees(pimg, 10.0d);
        assertEquals(1, actualRotateImageByDegreesResult.width);
        assertEquals(1, actualRotateImageByDegreesResult.getModifiedX2());
        assertTrue(actualRotateImageByDegreesResult.isLoaded());
        assertTrue(actualRotateImageByDegreesResult.isModified());
        assertEquals(0, actualRotateImageByDegreesResult.getModifiedY1());
        assertEquals(1, actualRotateImageByDegreesResult.format);
        assertEquals(1, actualRotateImageByDegreesResult.height);
        assertEquals(0, actualRotateImageByDegreesResult.getModifiedX1());
        assertEquals(1, actualRotateImageByDegreesResult.getModifiedY2());
        assertEquals(1, actualRotateImageByDegreesResult.pixelDensity);
        assertEquals(1, actualRotateImageByDegreesResult.pixelHeight);
        assertEquals(1, actualRotateImageByDegreesResult.pixelWidth);
        assertEquals(1, actualRotateImageByDegreesResult.get().pixelDensity);
        assertTrue(pimg.isLoaded());
    }

    /**
     * Method under test: {@link App#rotateImageByDegrees(PImage, double)}
     */
    @Test
    void testRotateImageByDegrees2() {
        App app = new App();
        PImage pimg = new PImage(2, 1);

        PImage actualRotateImageByDegreesResult = app.rotateImageByDegrees(pimg, 10.0d);
        assertEquals(2, actualRotateImageByDegreesResult.width);
        assertEquals(2, actualRotateImageByDegreesResult.getModifiedX2());
        assertTrue(actualRotateImageByDegreesResult.isLoaded());
        assertTrue(actualRotateImageByDegreesResult.isModified());
        assertEquals(0, actualRotateImageByDegreesResult.getModifiedY1());
        assertEquals(1, actualRotateImageByDegreesResult.format);
        assertEquals(1, actualRotateImageByDegreesResult.height);
        assertEquals(0, actualRotateImageByDegreesResult.getModifiedX1());
        assertEquals(1, actualRotateImageByDegreesResult.getModifiedY2());
        assertEquals(1, actualRotateImageByDegreesResult.pixelDensity);
        assertEquals(1, actualRotateImageByDegreesResult.pixelHeight);
        assertEquals(2, actualRotateImageByDegreesResult.pixelWidth);
        assertEquals(1, actualRotateImageByDegreesResult.get().pixelDensity);
        assertTrue(pimg.isLoaded());
    }

    /**
     * Method under test: {@link App#rotateImageByDegrees(PImage, double)}
     */
    @Test
    @Disabled()
    void testRotateImageByDegrees3() {
        App app = new App();
        PImage pimg = new PImage(6, 1);

        PImage actualRotateImageByDegreesResult = app.rotateImageByDegrees(pimg, 10.0d);
        assertEquals(6, actualRotateImageByDegreesResult.width);
        assertEquals(6, actualRotateImageByDegreesResult.getModifiedX2());
        assertTrue(actualRotateImageByDegreesResult.isLoaded());
        assertTrue(actualRotateImageByDegreesResult.isModified());
        assertEquals(0, actualRotateImageByDegreesResult.getModifiedY1());
        assertEquals(1, actualRotateImageByDegreesResult.format);
        assertEquals(2, actualRotateImageByDegreesResult.height);
        assertEquals(0, actualRotateImageByDegreesResult.getModifiedX1());
        assertEquals(2, actualRotateImageByDegreesResult.getModifiedY2());
        assertEquals(1, actualRotateImageByDegreesResult.pixelDensity);
        assertEquals(2, actualRotateImageByDegreesResult.pixelHeight);
        assertEquals(6, actualRotateImageByDegreesResult.pixelWidth);
        assertEquals(1, actualRotateImageByDegreesResult.get().pixelDensity);
        assertTrue(pimg.isLoaded());
    }
}

