package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;

/**
 * This class used to define function of "U3" button
 */
public class UpdateDamage extends Update{
    /**
     * Constructor: instantiates a new Update damage button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public UpdateDamage(int x, int y, int size) {
        super(x, y, size, "U3", "Upgrade\ndamage");
    }

    /**
     * create the function of "U3" button, update the damage to the tower.
     */
    @Override
    public void clickButton(App app) {
        this.setUsing(!this.isUsing());
        app.isUpdateTower[2] = !app.isUpdateTower[2] ;
        if (this.isUsing()) {
            app.towerLevel[2] = 1;
            Tower.TOWER_COST = Tower.TOWER_COST + Tower.LEVEL_COST[0];
        }
        else {
            app.towerLevel[2] = 0;
            Tower.TOWER_COST = Tower.TOWER_COST -  Tower.LEVEL_COST[0];
        }
    }
}
