package WizardTD.Pattern;

import WizardTD.App;
import processing.core.PImage;

/**
 * The type Pattern that will display in the map.
 * It has five child class: Grass, Path, Shrub, Tower, and WizardHouse.
 */
public abstract class Pattern {
    /**
     * The X coordinate of pattern.
     */
    protected int x;
    /**
     * The Y coordinate of pattern.
     */
    protected int y;
    /**
     * The image of the pattern.
     */
    protected PImage image;
    /**
     * The type of the pattern.
     */
    protected String type;

    /**
     * Constructor: instantiates a new Pattern.
     *
     * @param x    the x coordinate of pattern
     * @param y    the y coordinate of pattern
     * @param type the type of pattern
     */
    public Pattern(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.setType(type);
    }

    /**
     * Sets type of pattern.
     *
     * @param type the type of pattern
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets image of pattern.
     *
     * @param app the main app
     */
    public void setImage(App app) {
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
    }

    /**
     * Gets type of pattern.
     *
     * @return the type of pattern
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets x coordinate.
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y coordinate.
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Gets image of the pattern.
     *
     * @return the image
     */
    public PImage getImage() {
        return image;
    }
}
