package WizardTD.Pattern;

import WizardTD.App;

import java.awt.image.BufferedImage;

/**
 * The type Wizard house.
 */
public class WizardHouse extends Pattern{
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;

    /**
     * Constructor: instantiates a new Wizard house.
     *
     * @param x   the x coordinate of wizard house.
     * @param y   the y x coordinate of wizard house.
     * @param app the app
     */
    public WizardHouse(int x, int y, App app) {
        super(x, y, app, "wizard_house.png");
        this.path1 = null;
        this.path2 = null;
        this.path3 = null;
        this.path4 = null;
    }

    @Override
    public void setImage(App app) {
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
        this.image = app.rotateImageByDegrees(this.image, calculateHouseAngle(App.map, this.x, this.y) * 90);
    }

    @Override
    public void fillPixels(App app) {
        BufferedImage bufferedImage = (BufferedImage) this.image.getNative();
        app.loadPixels();
        for (int i = 0; i < bufferedImage.getHeight() && i + App.CELLSIZE * x + (App.CELLSIZE - bufferedImage.getHeight()) / 2 + App.TOPBAR < App.HEIGHT; i++) {
            for (int j = 0; j < bufferedImage.getWidth() && j + App.CELLSIZE * y + (App.CELLSIZE - bufferedImage.getWidth()) / 2 < App.WIDTH - App.SIDEBAR; j++) {
                if (bufferedImage.getRGB(j, i) != 0 && bufferedImage.getRGB(j, i) != -16777216) {
                    app.pixels[(App.TOPBAR + x * App.CELLSIZE + (App.CELLSIZE - bufferedImage.getHeight()) / 2) * App.WIDTH
                            + i * App.WIDTH + (y * App.CELLSIZE + (App.CELLSIZE - bufferedImage.getWidth()) / 2) + j] = bufferedImage.getRGB(j, i);
                }
            }
        }
        app.updatePixels();
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
