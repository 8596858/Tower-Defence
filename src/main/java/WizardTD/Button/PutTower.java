package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;

/**
 * This class used to define function of "T" button
 */
public class PutTower extends Button {
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
     * Display the info box beside the "T" button
     *
     * @param app the app
     */
    public void display(App app) {
        app.stroke(App.WORD_COLOR);
        app.fill(app.color(255, 255, 255));
        app.rect(this.x - App.SIDEBAR, this.y, 96, 16);
        app.fill(App.WORD_COLOR);
        app.textSize(13);
        app.text("Cost: " + Tower.TOWER_COST, this.x - App.SIDEBAR, this.y + 14);
    }

    /**
     * create the function of "T" button
     */
    @Override
    public void clickButton(App app) {
        if (isUsing) {
            this.setUsing(false);
            App.CAN_BUILD_TOWER = false;
        } else {
            if (app.manaBar.getProcess() >= Tower.TOWER_COST) {
                this.setUsing(true);
                App.CAN_BUILD_TOWER = true;
            }
        }
    }
}
