package WizardTD.Monster;

import WizardTD.App;
import WizardTD.Pattern.Path;
import processing.data.JSONObject;

/**
 * The monster type Worm.
 */
public class Worm extends Monster {
    /**
     * Constructor: instantiates a new Worm.
     *
     * @param path       the current path of monster
     * @param app        the app
     * @param jsonObject the json object
     */
    public Worm(Path path, App app, JSONObject jsonObject) {
        super(path, "worm.png", app, jsonObject);
    }

    @Override
    public boolean monsterDie(App app) {
        return true;
    }
}
