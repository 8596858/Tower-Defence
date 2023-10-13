package WizardTD.Pattern;

import WizardTD.App;
import WizardTD.Display;

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
        super(x, y, app, "tower0.png");
        this.timer = System.currentTimeMillis();
        this.level = new int[3];
        this.level[0] = app.towerLevel[0];
        this.level[1] = app.towerLevel[1];
        this.level[2] = app.towerLevel[2];
        updateTower(app);
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(int cost) {
        this.TOWER_COST = cost;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(double damage) {
        this.damage = damage;
    }

    /**
     * Sets firing speed.
     *
     * @param speed the speed
     */
    public void setFiringSpeed(double speed) {
        firingSpeed = speed;
    }

    /**
     * Sets range.
     *
     * @param range the range
     */
    public void setRange(double range) {
        this.range = range;
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
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
    }

    /**
     * Display the tower on the map.
     *
     * @param app the app
     */
    public void display(App app) {
        app.stroke(App.BUTTON_COLOR);
        app.fill(app.color(0, 0, 0), 0);
        app.ellipse(this.y * App.CELLSIZE + (float) App.CELLSIZE / 2, this.x * App.CELLSIZE + (float) App.CELLSIZE / 2 + App.TOPBAR, (float) this.range * 2, (float) this.range * 2);
        if (!(level[0] == 3 && level[1] == 3 && level[2] == 3) && (app.isUpdateTower[0] || app.isUpdateTower[1] || app.isUpdateTower[2])) {
            displayRect(app);
            displayText(app, 0);
        }
    }

    public void fillPixels(App app) {
        app.image(this.image, y * App.CELLSIZE, x * App.CELLSIZE + App.TOPBAR);
        if (!(this.level[0] == 1 && this.level[1] == 1 && this.level[2] == 1) &&
                !(this.level[0] == 2 && this.level[1] == 2 && this.level[2] == 2)) {
            app.stroke(app.color(252, 3, 227));
            app.fill(0,0);
            for (int i = 0; i < level[0]; i++) {
                app.ellipse(this.y * App.CELLSIZE + i * 4, this.x * App.CELLSIZE + App.TOPBAR, 4, 4);
            }
            for (int i = 0; i < level[2]; i++) {
                app.ellipse(this.y * App.CELLSIZE + i * 4, this.x * App.CELLSIZE + App.TOPBAR + App.CELLSIZE - 2, 4, 4);
            }
            app.stroke(app.color(3, 177, 252));
            for (int i = 0; i < level[1]; i++) {
                app.rect(this.y * App.CELLSIZE + i + 4, this.x * App.CELLSIZE + App.TOPBAR + i + 4, App.CELLSIZE - (4 + i) * 2, App.CELLSIZE - (4 + i) * 2);
            }
        }
    }

    @Override
    public void displayRect(App app) {
        app.stroke(App.WORD_COLOR);
        app.fill(app.color(255, 255, 255));
        app.rect(App.BOARD_WIDTH * App.CELLSIZE + 10, 17 * App.CELLSIZE, 96, 16);
        int h = 0;
        for (int i = 0; i < 3; i++) {
            if (app.isUpdateTower[i] && level[i] < 3) {
                h += 16;
            }
        }
        app.rect(App.BOARD_WIDTH * App.CELLSIZE + 10, 17 * App.CELLSIZE + 16, 96, h);
        app.rect(App.BOARD_WIDTH * App.CELLSIZE + 10, 17 * App.CELLSIZE + 16 + h, 96, 16);
    }

    @Override
    public void displayText(App app, int color) {
        app.fill(App.WORD_COLOR);
        app.textSize(13);
        app.text("Upgrade Cost", App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 14);
        int h = 15;
        int cost = 0;
        if (app.isUpdateTower[0] && level[0] < 3) {
            app.text("range:   " + LEVEL_COST[level[0]], App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h);
            h += 15;
            cost += LEVEL_COST[level[0]];
        }
        if (app.isUpdateTower[1] && level[1] < 3) {
            app.text("speed:   " + LEVEL_COST[level[1]], App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h);
            h += 15;
            cost += LEVEL_COST[level[1]];
        }
        if (app.isUpdateTower[2] && level[2] < 3) {
            app.text("damage:  " + LEVEL_COST[level[2]], App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h);
            h += 15;
            cost += LEVEL_COST[level[2]];
        }
        app.text("Total:    " + cost, App.BOARD_WIDTH * App.CELLSIZE + 12, 17 * App.CELLSIZE + 15 + h);
    }
}
