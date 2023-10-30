package WizardTD;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import WizardTD.Button.ButtonList;
import org.junit.jupiter.api.Test;

class AppTest {
    App app;
    /**
     * Test if the App can be instantiated correctly.
     */
    @Test
    void testConstructor() {
        app = new App();
    }

    /**
     * Test mapInfo(JsonInfo) method in App.
     */
    @Test
    void testMapInfo() {
        app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        App.map = app.mapInfo(app.jsonInfo);
    }

    /**
     * Test buildMap(App, Paths) method in App.
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
     * Test mouseInMap() method in App.
     */
    @Test
    void testMouseInMap() {
        app = new App();
        assertFalse(app.mouseInMap());
    }

    /**
     * Test mouseInButton(Buttons) method in App.
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
     * Test patternCoordinate(int, int) method in App.
     */
    @Test
    void testPatternCoordinate() {
        app = new App();
        assertArrayEquals(new int[]{1, 1}, app.patternCoordinate(72, 32));
    }
}

