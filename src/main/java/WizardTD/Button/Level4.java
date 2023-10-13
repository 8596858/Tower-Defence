package WizardTD.Button;

import WizardTD.App;

public class Level4 extends Button{
    /**
     * Constructor: instantiates a new Level4 button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public Level4(int x, int y, int size) {
        super(x, y, size, "4", "");
    }

    /**
     * create the function of "Level4" button
     */
    @Override
    public void clickButton(App app) {
        app.configPath = "config4.json";
    }
}
