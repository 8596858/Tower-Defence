package WizardTD.Button;

import WizardTD.App;

public class Level2 extends Button{
    /**
     * Constructor: instantiates a new Level2 button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public Level2(int x, int y, int size) {
        super(x, y, size, "2", "");
    }

    /**
     * create the function of "Level2" button, activate the level two game.
     */
    @Override
    public void clickButton(App app) {
        app.configPath = "config2.json";
    }
}
