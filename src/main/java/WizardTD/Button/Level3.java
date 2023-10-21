package WizardTD.Button;

import WizardTD.App;

public class Level3 extends Button{
    /**
     * Constructor: instantiates a new Level3 button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public Level3(int x, int y, int size) {
        super(x, y, size, "3", "");
    }

    /**
     * create the function of "Level3" button, activate the level three game.
     */
    @Override
    public void clickButton(App app) {
        app.configPath = "config3.json";
    }
}
