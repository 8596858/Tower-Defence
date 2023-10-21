package WizardTD.Button;

import WizardTD.App;
import WizardTD.Manager.Shape;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.Text;
import WizardTD.Manager.TextManager;
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
     * Put the shape and text that show the cost of tower into the manager.
     *
     * @param shapeManager the shape manager
     * @param textManager  the text manager
     */
    public void display(ShapeManager shapeManager, TextManager textManager) {
        shapeManager.addNewShape(new Shape(this.x - App.SIDEBAR, this.y, 96, 16, 1, App.WORD_COLOR, App.WHITE_COLOR, 1));
        textManager.addNewText(new Text("Cost: " + Tower.TOWER_COST, this.x - App.SIDEBAR, this.y + 14, 13, App.WORD_COLOR));
    }

    /**
     * create the function of "T" button, put tower in the map.
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
