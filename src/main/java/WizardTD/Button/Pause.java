package WizardTD.Button;

import WizardTD.App;

/**
 * This class used to define function of "P" button
 */
public class Pause extends Button{
    /**
     * Constructor: instantiates a new Pause button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public Pause(int x, int y, int size) {
        super(x, y, size, "P", "PAUSE");
    }

    /**
     * create the function of "P" button
     */
    @Override
    public void clickButton(App app) {
        this.setUsing(!this.isUsing());
        App.PAUSE = this.isUsing();
    }
}
