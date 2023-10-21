package WizardTD.Button;

import WizardTD.App;

public class Level1 extends Button{
    /**
     * Constructor: instantiates a new Level3 button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public Level1(int x, int y, int size) {
        super(x, y, size, "1", "");
    }

    /**
     * create the function of "Level1" button, activate the level one game.
     */
    @Override
    public void clickButton(App app) {
        app.configPath = "config1.json";
    }
}
