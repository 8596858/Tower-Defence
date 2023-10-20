package WizardTD.Monster;

import WizardTD.App;
import WizardTD.Pattern.Path;
import processing.data.JSONObject;

/**
 * The monster type Gremlin.
 */
public class Gremlin extends Monster {
    private int index;

    /**
     * Constructor: instantiates a new Gremlin.
     *
     * @param path       the start path
     * @param app        the app
     * @param jsonObject the json object
     */
    public Gremlin(Path path, App app, JSONObject jsonObject) {
        super(path, "gremlin.png", app, jsonObject);
        index = 0;
    }

    /**
     * The process of monster die.
     *
     * @param app the app
     */
    @Override
    public boolean monsterDie(App app) {
        if (index < 24) {
            if (index >= 4) {
                this.type = "gremlin" + (index / 4) + ".png";
            }
        }
        else {
            return true;
        }
        index++;
        return false;
    }
}