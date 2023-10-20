package WizardTD.Pattern;

import WizardTD.App;

import java.util.ArrayList;

/**
 * This class define the path part in the map.
 * This class can be used as a linked list,
 * where parent is the next path to the wizard's house.
 * The path' parent connected to the wizard's house is null
 */
public class Path extends Pattern{
    private double[] pathType;
    private ArrayList<Path> parent;
    private ArrayList<Integer> direction;
    private int length;

    /**
     * Constructor: instantiates a new Path.
     * @param x the x coordinate of path
     * @param y the y coordinate of path
     */
    public Path(int x, int y) {
        super(x, y, "path");
        this.parent = new ArrayList<>();
        this.length = 0;
        this.direction = new ArrayList<>();
    }


    /**
     * Sets possible parents.
     *
     * @param parent the parent path
     */
    public void setParent(Path parent) {
        this.parent.add(parent);
    }

    /**
     * Clear parent list.
     */
    public void clearParent() {
        this.parent.clear();
    }

    /**
     * Sets possible directions.
     *
     * @param direction the direction
     */
    public void setDirection(int direction) {
        this.direction.add(direction);
    }

    /**
     * Clear direction list.
     */
    public void clearDirection() {
        this.direction.clear();
    }

    /**
     * Sets length of the path form this point.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void setImage(App app) {
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
        this.image = app.rotateImageByDegrees(this.image, this.pathType[1]);
    }

    @Override
    public void setType(String type) {
        this.pathType = calculatePathAngle(App.map, this.x, this.y);
        this.type = type + String.format("%.0f", this.pathType[0]) + ".png";
    }

    /**
     * Gets direction of path.
     *
     * @return the direction of path
     */
    public ArrayList<Integer> getDirection() {
        return direction;
    }

    /**
     * Gets parent of path.
     *
     * @return the parent of path
     */
    public ArrayList<Path> getParent() {
        return this.parent;
    }

    /**
     * Gets length of path from this point.
     *
     * @return the length of path from this point.
     */
    public int getLength() {
        return length;
    }

    /**
     * Calculate the type of the path and rotate angle
     *
     * @param map the map
     * @param i the vertical position of path pattern
     * @param j the horizontal position of path pattern
     * @return the double[], first element represent the type and second element represent rotate angle of the path image
     */
    public double[] calculatePathAngle(char[][] map, int i, int j) {
        double[] result = new double[2];
        int n = 0;
        if ((i == map.length - 1 || map[i + 1][j] == 'X') &&
                (i == 0 || map[i - 1][j] == 'X') &&
                (j == map[0].length - 1 || map[i][j + 1] == 'X') &&
                (j == 0 || map[i][j - 1] == 'X')) {
            result[0] = 3;
            result[1] = 0;
        }
        else if ((i == map.length - 1 || map[i + 1][j] == 'X') &&
                (j == 0 || map[i][j - 1] == 'X') &&
                (j == map[0].length - 1 || map[i][j + 1] == 'X')) {
            result[0] = 2;
            result[1] = 0;
        }
        else if ((j == 0 || map[i][j - 1] == 'X') &&
                (i == 0 || map[i - 1][j] == 'X') &&
                (i == map.length - 1 || map[i + 1][j] == 'X')) {
            result[0] = 2;
            result[1] = 90;
        }
        else if ((i == 0 || map[i - 1][j] == 'X') &&
                (j == 0 || map[i][j - 1] == 'X') &&
                (j == map[0].length - 1 || map[i][j + 1] == 'X')) {
            result[0] = 2;
            result[1] = 180;
        }
        else if ((j == map[0].length - 1 || map[i][j + 1] == 'X') &&
                (i == 0 || map[i - 1][j] == 'X') &&
                (i == map.length - 1 || map[i + 1][j] == 'X')) {
            result[0] = 2;
            result[1] = -90;
        }
        else if ((i == 0 || map[i - 1][j] == 'X') && (j == 0 || map[i][j - 1] == 'X')) {
            result[0] = 1;
            result[1] = 90;
        }
        else if ((i == map.length - 1 || map[i + 1][j] == 'X') && (j == 0 || map[i][j - 1] == 'X')) {
            result[0] = 1;
            result[1] = 0;
        }
        else if ((i == 0 || map[i - 1][j] == 'X') && (j == map[0].length - 1 || map[i][j + 1] == 'X')) {
            result[0] = 1;
            result[1] = 180;
        }
        else if ((i == map.length - 1 || map[i + 1][j] == 'X') && (j == map[0].length - 1 || map[i][j + 1] == 'X')) {
            result[0] = 1;
            result[1] = -90;
        }
        else if ((i == 0 || map[i - 1][j] == 'X') || (map[i + 1][j] == 'X' || i == map.length - 1)) {
            result[0] = 0;
            result[1] = 90;
        }
        else if ((j == map[0].length - 1 || map[i][j + 1] == 'X') || (j == 0 || map[i][j - 1] == 'X')) {
            result[0] = 0;
            result[1] = 0;
        }
        return result;
    }
}
