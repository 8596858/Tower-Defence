package WizardTD.Pattern;

import WizardTD.App;

/**
 * This class define the grass part in the map.
 */
public class Grass extends Pattern{

    /**
     * Constructor: instantiates a new Grass.
     *
     * @param x   the x coordinate
     * @param y   the y coordinate
     * @param app the main app
     */
    public Grass(int x, int y, App app) {
        super(x, y, app, "grass.png");
    }
}
