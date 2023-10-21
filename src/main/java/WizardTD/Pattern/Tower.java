package WizardTD.Pattern;

import WizardTD.App;
import WizardTD.Display;
import WizardTD.Manager.Shape;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.Text;
import WizardTD.Manager.TextManager;

/**
 * The type Tower.
 */
public class Tower extends Pattern implements Display {
    /**
     * The constant tower cost.
     */
    public static int TOWER_COST;
    /**
     * The Level cost.
     */
    public static int[] LEVEL_COST = {20, 30, 40};
    private double firingSpeed;
    private long timer;
    private int[] level;
    private double range;
    private double damage;

    /**
     * Constructor: instantiates a new Tower.
     *
     * @param x   the x coordinate of tower.
     * @param y   the y coordinate of tower.
     * @param app the app
     */
    public Tower(int x, int y, App app) {
        super(x, y, "tower0.png");
        this.timer = System.currentTimeMillis();
        this.level = new int[3];
        this.level[0] = app.towerLevel[0];
        this.level[1] = app.towerLevel[1];
        this.level[2] = app.towerLevel[2];
        updateTower(app);
    }

    /**
     * Sets timer.
     *
     * @param timer the timer
     */
    public void setTimer(long timer) {
        this.timer = timer;
    }

    /**
     * Sets if accelerated. The fire speed will two time faster if accelerated.
     */
    public void setAccelerate() {
        if (App.IS_ACCELERATE) {
            firingSpeed = firingSpeed * 2;
        }
        else {
            firingSpeed = firingSpeed / 2;
        }
    }

    /**
     * Gets fire range.
     *
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * Gets firing speed.
     *
     * @return the firing speed
     */
    public double getFiringSpeed() {
        return firingSpeed;
    }

    /**
     * Gets damage from the fireball.
     *
     * @return the damage
     */
    public double getDamage() {
        return damage;
    }

    /**
     * Gets the timer.
     *
     * @return the timer
     */
    public long getTimer() {
        return timer;
    }

    /**
     * Update level.
     *
     * @param isUpdateTower the is update tower
     * @param app           the app
     */
    public void updateLevel(boolean[] isUpdateTower, App app) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            if (isUpdateTower[i]) {
                if (level[i] == 0) {
                    cost = cost + LEVEL_COST[0];
                }
                else if (level[i] == 1) {
                    cost = cost + LEVEL_COST[1];
                }
                else if (level[i] == 2) {
                    cost = cost + LEVEL_COST[2];
                }
            }
        }
        if (app.manaBar.getProcess() > cost) {
            for (int i = 0; i < 3; i++) {
                if (isUpdateTower[i]) {
                    if (this.level[i] < 3) {
                        this.level[i]++;
                    }
                }
            }
            app.manaBar.updateProcess(cost);
            this.updateTower(app);
        }
    }

    private void updateTower(App app) {
        if (this.level[0] == 0) {
            this.range = app.jsonInfo.getInitial_tower_range();
        }
        else if (this.level[0] == 1) {
            this.range = app.jsonInfo.getInitial_tower_range() + 32;
        }
        else if (this.level[0] == 2) {
            this.range = app.jsonInfo.getInitial_tower_range() + 64;
        }
        else if (this.level[0] == 3) {
            this.range = app.jsonInfo.getInitial_tower_range() + 96;
        }
        if (this.level[1] == 0) {
            firingSpeed = app.jsonInfo.getInitial_tower_firing_speed();
        }
        else if (this.level[1] == 1) {
            firingSpeed = app.jsonInfo.getInitial_tower_firing_speed() + 0.5;
        }
        else if (this.level[1] == 2) {
            firingSpeed = app.jsonInfo.getInitial_tower_firing_speed() + 1;
        }
        else if (this.level[1] == 3) {
            firingSpeed = app.jsonInfo.getInitial_tower_firing_speed() + 1.5;
        }
        if (this.level[2] == 0) {
            this.damage = app.jsonInfo.getInitial_tower_damage();
        }
        else if (this.level[2] == 1) {
            this.damage = app.jsonInfo.getInitial_tower_damage() * 1.5;
        }
        else if (this.level[2] == 2) {
            this.damage = app.jsonInfo.getInitial_tower_damage() * 2;
        }
        else if (this.level[2] == 3) {
            this.damage = app.jsonInfo.getInitial_tower_damage() * 2.5;
        }
        if (this.level[0] >= 2 && this.level[1] >= 2 && this.level[2] >= 2) {
            this.type = "tower2.png";
        }
        else if (this.level[0] >= 1 && this.level[1] >= 1 && this.level[2] >= 1) {
            this.type = "tower1.png";
        }
        else {
            this.type = "tower0.png";
        }
    }

    /**
     * Display the tower on the map.
     *
     * @param app the app
     * @param shapeManager the shape manager
     * @param textManager the text manager
     */
    public void display(App app, ShapeManager shapeManager, TextManager textManager) {
        shapeManager.addNewShape(new Shape(this.y * App.CELLSIZE + (float) App.CELLSIZE / 2, this.x * App.CELLSIZE + (float) App.CELLSIZE / 2 + App.TOPBAR,
                (float) this.range * 2, (float) this.range * 2, 2, App.BUTTON_COLOR, 0, 0));
        if (!(level[0] == 3 && level[1] == 3 && level[2] == 3) && (app.isUpdateTower[0] || app.isUpdateTower[1] || app.isUpdateTower[2])) {
            addShape(app, shapeManager);
            addText(app, textManager);
        }
    }

    /**
     * Add the shape that display the level of the tower into the shape manager.
     *
     * @param shapeManager the shape manager
     */
    public void fillPixels(ShapeManager shapeManager) {
        if (!(this.level[0] == 1 && this.level[1] == 1 && this.level[2] == 1) &&
                !(this.level[0] == 2 && this.level[1] == 2 && this.level[2] == 2)) {
            for (int i = 0; i < level[0]; i++) {
                shapeManager.addNewShape(new Shape(this.y * App.CELLSIZE + i * 4, this.x * App.CELLSIZE + App.TOPBAR,
                        4, 4, 2, App.LEVEL_COLOR1, 0, 0));
            }
            for (int i = 0; i < level[2]; i++) {
                shapeManager.addNewShape(new Shape(this.y * App.CELLSIZE + i * 4, this.x * App.CELLSIZE + App.TOPBAR + App.CELLSIZE - 2,
                        4, 4, 2, App.LEVEL_COLOR1, 0, 0));
            }
            for (int i = 0; i < level[1]; i++) {
                shapeManager.addNewShape(new Shape(this.y * App.CELLSIZE + i + 4, this.x * App.CELLSIZE + App.TOPBAR + i + 4,
                        App.CELLSIZE - (4 + i) * 2, App.CELLSIZE - (4 + i) * 2, 1, App.LEVEL_COLOR2, 0, 0));
            }
        }
    }

    /**
     * Add the shape that display the update info of the tower to the shape manager.
     *
     * @param app the app
     * @param shapeManager the shape manager
     */
    @Override
    public void addShape(App app, ShapeManager shapeManager) {
        shapeManager.addNewShape(new Shape(App.BOARD_WIDTH * App.CELLSIZE + 10, 17 * App.CELLSIZE,
                96, 16, 1, App.WORD_COLOR, App.WHITE_COLOR, 1));
        int h = 0;
        for (int i = 0; i < 3; i++) {
            if (app.isUpdateTower[i] && level[i] < 3) {
                h += 16;
            }
        }
        shapeManager.addNewShape(new Shape(App.BOARD_WIDTH * App.CELLSIZE + 10, 17 * App.CELLSIZE + 16,
                96, h, 1, App.WORD_COLOR, App.WHITE_COLOR, 1));
        shapeManager.addNewShape(new Shape(App.BOARD_WIDTH * App.CELLSIZE + 10, 17 * App.CELLSIZE + 16 + h,
                96, 16, 1, App.WORD_COLOR, App.WHITE_COLOR, 1));
    }

    /**
     * Add the text that display the update info of the tower to the text manager.
     *
     * @param app the app
     * @param textManager the text manager
     */
    @Override
    public void addText(App app, TextManager textManager) {
        textManager.addNewText(new Text("Upgrade Cost", App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 14, 13, App.WORD_COLOR));
        int h = 15;
        int cost = 0;
        if (app.isUpdateTower[0] && level[0] < 3) {
            textManager.addNewText(new Text("range:   " + LEVEL_COST[level[0]], App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h, 13, App.WORD_COLOR));
            h += 15;
            cost += LEVEL_COST[level[0]];
        }
        if (app.isUpdateTower[1] && level[1] < 3) {
            textManager.addNewText(new Text("speed:   " + LEVEL_COST[level[1]], App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h, 13, App.WORD_COLOR));
            h += 15;
            cost += LEVEL_COST[level[1]];
        }
        if (app.isUpdateTower[2] && level[2] < 3) {
            textManager.addNewText(new Text("damage:  " + LEVEL_COST[level[2]], App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h, 13, App.WORD_COLOR));
            h += 15;
            cost += LEVEL_COST[level[2]];
        }
        textManager.addNewText(new Text("Total:    " + cost, App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h, 13, App.WORD_COLOR));
    }
}
