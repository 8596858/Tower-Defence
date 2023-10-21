package WizardTD.Monster;

import WizardTD.App;
import WizardTD.Pattern.Path;
import processing.data.JSONObject;

/**
 * The monster type Worm.
 */
public class Worm extends Monster {
    private int index;

    /**
     * Constructor: instantiates a new Worm.
     *
     * @param path       the current path of monster
     * @param app        the app
     * @param jsonObject the json object
     */
    public Worm(Path path, App app, JSONObject jsonObject) {
        super(path, "worm.png", app, jsonObject);
        index = 0;
    }

    /**
     * Process of worm die.
     *
     * @param app the main app
     * @return if the process is finish
     */
    @Override
    public boolean monsterDie(App app) {
        if (index < 16) {
            if (index >= 4) {
                this.type = "worm" + (index / 4) + ".png";
            }
        }
        else {
            return true;
        }
        index++;
        return false;
    }
}
