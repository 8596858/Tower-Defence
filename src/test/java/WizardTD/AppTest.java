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
    @Test
    void testConstructor() {
        app = new App();
    }

    @Test
    void testMapInfo() {
        app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
    }

    @Test
    void testBuildMap() {
        app = new App();
        app.paths = new Paths();
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
        app.buildMap(App.map, app.paths);
    }

    @Test
    void testMouseInMap() {
        app = new App();
        assertFalse(app.mouseInMap());
    }

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

    @Test
    void testPatternCoordinate() {
        app = new App();
        assertArrayEquals(new int[]{1, 1}, app.patternCoordinate(72, 32));
    }
}

