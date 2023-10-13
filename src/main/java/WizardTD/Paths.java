package WizardTD;

import WizardTD.Pattern.Path;
import WizardTD.Pattern.Pattern;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The type Paths.
 */
public class Paths {
    private ArrayList<Path> startPoints;

    /**
     * Constructor: instantiates a new Paths.
     */
    public Paths() {
        startPoints = new ArrayList<>();
    }

    /**
     * Gets start points.
     *
     * @return the start points
     */
    public ArrayList<Path> getStartPoints() {
        return startPoints;
    }

    /**
     * Sets start points.
     *
     * @param path the path
     */
    public void setStartPoints(Path path) {
        startPoints.add(path);
    }

    /**
     * Find paths. Set the parent of each path, so that monster can know where to go.
     *
     * @param app the main app
     */
    public void findPaths(App app) {
        Stack<Pattern> openList = new Stack<>();
        ArrayList<Integer> closedList = new ArrayList<>();
        if (app.wizardHouse.getX() - 1 != -1 && App.map[app.wizardHouse.getX() - 1][app.wizardHouse.getY()] == 'X') {
            ((Path)app.patterns[app.wizardHouse.getX() - 1][app.wizardHouse.getY()]).setLength(0);
            ((Path)app.patterns[app.wizardHouse.getX() - 1][app.wizardHouse.getY()]).setDirection(0);
            openList.push(app.patterns[app.wizardHouse.getX() - 1][app.wizardHouse.getY()]);
            closedList.add(app.patterns[app.wizardHouse.getX() - 1][app.wizardHouse.getY()].hashCode());
        }
        if (app.wizardHouse.getX() + 1 != 20 && App.map[app.wizardHouse.getX() + 1][app.wizardHouse.getY()] == 'X') {
            ((Path)app.patterns[app.wizardHouse.getX() + 1][app.wizardHouse.getY()]).setLength(0);
            ((Path)app.patterns[app.wizardHouse.getX() + 1][app.wizardHouse.getY()]).setDirection(1);
            openList.push(app.patterns[app.wizardHouse.getX() + 1][app.wizardHouse.getY()]);
            closedList.add(app.patterns[app.wizardHouse.getX() + 1][app.wizardHouse.getY()].hashCode());
        }
        if (app.wizardHouse.getY() - 1 != -1 && App.map[app.wizardHouse.getX()][app.wizardHouse.getY() - 1] == 'X') {
            ((Path)app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() - 1]).setLength(0);
            ((Path)app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() - 1]).setDirection(2);
            openList.push(app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() - 1]);
            closedList.add(app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() - 1].hashCode());
        }
        if (app.wizardHouse.getY() + 1 != 20 && App.map[app.wizardHouse.getX()][app.wizardHouse.getY() + 1] == 'X') {
            ((Path)app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() + 1]).setLength(0);
            ((Path)app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() + 1]).setDirection(3);
            openList.push(app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() + 1]);
            closedList.add(app.patterns[app.wizardHouse.getX()][app.wizardHouse.getY() + 1].hashCode());
        }
        while (!openList.empty()) {
            Path temp = (Path)openList.pop();
            if (temp.getX() - 1 != -1 && App.map[temp.getX() - 1][temp.getY()] == 'X') {
                if (closedList.contains(app.patterns[temp.getX() - 1][temp.getY()].hashCode())) {
                    if (((Path)app.patterns[temp.getX() - 1][temp.getY()]).getLength() > temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setLength(temp.getLength() + 1);
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearParent();
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearDirection();
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setParent(temp);
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setDirection(0);
                    }
                    else if (((Path)app.patterns[temp.getX() - 1][temp.getY()]).getLength() == temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setParent(temp);
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setDirection(0);
                    }
                }
                else {
                    ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setLength(temp.getLength() + 1);
                    ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setParent(temp);
                    ((Path)app.patterns[temp.getX() - 1][temp.getY()]).setDirection(0);
                    openList.push(app.patterns[temp.getX() - 1][temp.getY()]);
                    closedList.add(app.patterns[temp.getX() - 1][temp.getY()].hashCode());
                }
            }
            if (temp.getX() + 1 != 20 && App.map[temp.getX() + 1][temp.getY()] == 'X') {
                if (closedList.contains(app.patterns[temp.getX() + 1][temp.getY()].hashCode())) {
                    if (((Path)app.patterns[temp.getX() + 1][temp.getY()]).getLength() > temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setLength(temp.getLength() + 1);
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearParent();
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearDirection();
                        ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setParent(temp);
                        ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setDirection(1);
                    }
                    else if (((Path)app.patterns[temp.getX() + 1][temp.getY()]).getLength() == temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setParent(temp);
                        ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setDirection(1);
                    }
                }
                else {
                    ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setLength(temp.getLength() + 1);
                    ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setParent(temp);
                    ((Path)app.patterns[temp.getX() + 1][temp.getY()]).setDirection(1);
                    openList.push(app.patterns[temp.getX() + 1][temp.getY()]);
                    closedList.add(app.patterns[temp.getX() + 1][temp.getY()].hashCode());
                }
            }
            if (temp.getY() - 1 != -1 && App.map[temp.getX()][temp.getY() - 1] == 'X') {
                if (closedList.contains(app.patterns[temp.getX()][temp.getY() - 1].hashCode())) {
                    if (((Path)app.patterns[temp.getX()][temp.getY() - 1]).getLength() > temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setLength(temp.getLength() + 1);
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearParent();
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearDirection();
                        ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setParent(temp);
                        ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setDirection(2);
                    }
                    else if (((Path)app.patterns[temp.getX()][temp.getY() - 1]).getLength() == temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setParent(temp);
                        ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setDirection(2);
                    }
                }
                else {
                    ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setLength(temp.getLength() + 1);
                    ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setParent(temp);
                    ((Path)app.patterns[temp.getX()][temp.getY() - 1]).setDirection(2);
                    openList.push(app.patterns[temp.getX()][temp.getY() - 1]);
                    closedList.add(app.patterns[temp.getX()][temp.getY() - 1].hashCode());
                }
            }
            if (temp.getY() + 1 != 20 && App.map[temp.getX()][temp.getY() + 1] == 'X') {
                if (closedList.contains(app.patterns[temp.getX()][temp.getY() + 1].hashCode())) {
                    if (((Path)app.patterns[temp.getX()][temp.getY() + 1]).getLength() > temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setLength(temp.getLength() + 1);
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearParent();
                        ((Path)app.patterns[temp.getX() - 1][temp.getY()]).clearDirection();
                        ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setParent(temp);
                        ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setDirection(3);
                    }
                    else if (((Path)app.patterns[temp.getX()][temp.getY() + 1]).getLength() == temp.getLength() + 1) {
                        ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setParent(temp);
                        ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setDirection(3);
                    }
                }
                else {
                    ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setLength(temp.getLength() + 1);
                    ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setParent(temp);
                    ((Path)app.patterns[temp.getX()][temp.getY() + 1]).setDirection(3);
                    openList.push(app.patterns[temp.getX()][temp.getY() + 1]);
                    closedList.add(app.patterns[temp.getX()][temp.getY() + 1].hashCode());
                }
            }
        }
    }
}
