package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;

/**
 * This class used to define function of "U1" button
 */
public class UpdateRange extends Update{
    /**
     * Constructor: instantiates a new Update range button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public UpdateRange(int x, int y, int size) {
        super(x, y, size, "U1", "Upgrade\nrange");
    }

    /**
     * create the function of "U1" button, update the range of the tower.
     */
    @Override
    public void clickButton(App app) {
        this.setUsing(!this.isUsing());
        app.isUpdateTower[0] = !app.isUpdateTower[0];
        if (this.isUsing()) {
            app.towerLevel[0] = 1;
            Tower.TOWER_COST = Tower.TOWER_COST + Tower.LEVEL_COST[0];
        }
        else {
            app.towerLevel[0] = 0;
            Tower.TOWER_COST = Tower.TOWER_COST - Tower.LEVEL_COST[0];
        }
    }
}
