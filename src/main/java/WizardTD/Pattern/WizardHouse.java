package WizardTD.Pattern;

import WizardTD.App;

/**
 * The type wizard house.
 */
public class WizardHouse extends Pattern{

    /**
     * Constructor: instantiates a new wizard house.
     *
     * @param x   the x coordinate of wizard house.
     * @param y   the y x coordinate of wizard house.
     */
    public WizardHouse(int x, int y) {
        super(x, y, "wizard_house.png");
    }

    /**
     * Sets image for the wizard house, and rotate it to the right angle.
     *
     * @param app the main app
     */
    @Override
    public void setImage(App app) {
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
        this.image = app.rotateImageByDegrees(this.image, calculateHouseAngle(App.map, this.x, this.y) * 90);
    }

    /**
     * Calculate house angle.
     *
     * @param map the map
     * @param i   the vertical position of wizard house.
     * @param j   the horizontal position of wizard house.
     * @return the house angle
     */
    public double calculateHouseAngle(char[][] map, int i, int j) {
        double result = 0;
        if (i != 0 && map[i - 1][j] == 'X') {
            result = 3;
        } else if (j != 0 && map[i][j - 1] == 'X') {
            result = 2;
        } else if (i != map.length - 1 && map[i + 1][j] == 'X') {
            result = 1;
        } else if (j != map[0].length - 1 && map[i][j + 1] == 'X') {
            result = 0;
        }
        return result;
    }
}
