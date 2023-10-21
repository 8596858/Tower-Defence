package WizardTD.Button;

import WizardTD.App;
import WizardTD.Pattern.Tower;

/**
 * This class used to define function of "U2" button
 */
public class UpdateSpeed extends Update{
    /**
     * Constructor: instantiates a new Update speed button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public UpdateSpeed(int x, int y, int size) {
        super(x, y, size, "U2", "Upgrade\nspeed");
    }

    /**
     * create the function of "U2" button, the firing speed of the tower.
     */
    @Override
    public void clickButton(App app) {
        this.setUsing(!this.isUsing());
        app.isUpdateTower[1] = !app.isUpdateTower[1] ;
        if (this.isUsing()) {
            app.towerLevel[1] = 1;
            Tower.TOWER_COST = Tower.TOWER_COST + Tower.LEVEL_COST[0];
        }
        else {
            app.towerLevel[1] = 0;
            Tower.TOWER_COST = Tower.TOWER_COST - Tower.LEVEL_COST[0];
        }
    }
}
