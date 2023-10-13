package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;

/**
 * This class used to define function of "T" button
 */
public class PutTower extends Button{
    /**
     * Constructor: instantiates a new Put tower button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public PutTower(int x, int y, int size) {
        super(x, y, size, "T", "Build\ntower");
    }

    /**
     * create the function of "T" button
     */
    @Override
    public void clickButton(App app) {
        if (isUsing) {
            this.setUsing(false);
            App.CAN_BUILD_TOWER = false;
        }
        else {
            if (app.manaBar.getProcess() >= Tower.TOWER_COST) {
                this.setUsing(true);
                App.CAN_BUILD_TOWER = true;
            }
        }
    }
}
