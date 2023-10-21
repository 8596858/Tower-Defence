package WizardTD.Button;

import WizardTD.App;
import WizardTD.FireBall;
import WizardTD.Monster.Monster;
import WizardTD.Pattern.Tower;

/**
 * This class used to define function of "FF" button
 */
public class FasterSpeed extends Button{
    /**
     *Constructor: instantiates a new faster speed button.
     *
     * @param x    the x coordinate of button
     * @param y    the y coordinate of button
     * @param size the size of button
     */
    public FasterSpeed(int x, int y, int size) {
        super(x, y, size, "FF", "2x speed");
    }

    /**
     * create the function of "FF" button, make the game two times faster.
     */
    @Override
    public void clickButton(App app) {
        this.setUsing(!this.isUsing());
        App.IS_ACCELERATE = !App.IS_ACCELERATE;
        app.monsterManager.setAccelerate();
        FireBall.setAccelerate();
        for (Tower tower : app.towers) {
            tower.setAccelerate();
        }
        if (this.isUsing()) {
            Monster.TIME_INTERVAL = Monster.TIME_INTERVAL / 2;
            app.showWave.setSpeed(2);
        }
        else {
            Monster.TIME_INTERVAL = Monster.TIME_INTERVAL * 2;
            app.showWave.setSpeed(1);
        }
    }
}
