package WizardTD.Pattern;

import WizardTD.App;

/**
 * The type Shrub .
 */
public class Shrub extends Pattern{
    /**
     * Constructor: instantiates a new Shrub.
     *
     * @param x   the x coordinate of shrub.
     * @param y   the y coordinate of shrub.
     * @param app the app
     */
    public Shrub(int x, int y, App app) {
        super(x, y, app, "shrub.png");
    }
}
