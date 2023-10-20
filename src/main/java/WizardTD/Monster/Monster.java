package WizardTD.Monster;

import WizardTD.App;
import WizardTD.Display;
import WizardTD.Effect;
import WizardTD.Pattern.Path;
import processing.core.PImage;
import processing.data.JSONObject;

/**
 * The type Monster.
 */
public abstract class Monster implements Display, Effect {
    /**
     * The constant TIME_INTERVAL.
     */
    public static double TIME_INTERVAL = 0;
    /**
     * The constant SPEED.
     */
    protected float speed;
    /**
     * The X coordinate of monster.
     */
    protected float x;
    /**
     * The Y coordinate of monster.
     */
    protected float y;
    /**
     * The Start x coordinate of monster.
     */
    protected float startX;
    /**
     * The Start y.
     */
    protected float startY;
    /**
     * The Starter path.
     */
    protected Path startentPath;
    /**
     * The Current path.
     */
    protected Path currentPath;
    /**
     * The Type.
     */
    protected String type;
    /**
     * The Image.
     */
    protected PImage image;
    /**
     * The current hp.
     */
    protected double hp;
    /**
     * The Top hp.
     */
    protected double topHp;

    /**
     * The Armour.
     */
    protected double armour;
    /**
     * The Mana gained on kill.
     */
    protected double manaGainedOnKill;

    private boolean die;

    private int index;

    /**
     * Constructor: instantiates a new Monster.
     *
     * @param path       the current path of monster
     * @param type       the type of monster
     * @param app        the main app
     * @param jsonObject the json object
     */
    public Monster(Path path, String type, App app, JSONObject jsonObject) {
        this.type = type;
        this.startentPath = path;
        this.currentPath = path;
        if (path.getX() == 0) {
            this.x = -App.CELLSIZE + App.TOPBAR;
            this.y = path.getY() * App.CELLSIZE;
        }
        else if (path.getX() == 19) {
            this.x = 20 * App.CELLSIZE + App.TOPBAR;
            this.y = path.getY() * App.CELLSIZE;
        }
        else if (path.getY() == 0) {
            this.x = path.getX() * App.CELLSIZE + App.TOPBAR;
            this.y = -App.CELLSIZE;
        }
        else if (path.getY() == 19) {
            this.x = path.getX() * App.CELLSIZE + App.TOPBAR;
            this.y = 20 * App.CELLSIZE;
        }
        this.startX = this.x;
        this.startY = this.y;
        this.hp = jsonObject.getDouble("hp");
        this.topHp = jsonObject.getDouble("hp");
        if (App.IS_ACCELERATE) {
            speed = jsonObject.getFloat("speed") * 2;
        }
        else {
            speed = jsonObject.getFloat("speed");
        }
        this.armour = jsonObject.getDouble("armour");
        this.manaGainedOnKill = jsonObject.getDouble("mana_gained_on_kill");
        this.die = false;
        if (currentPath != null) {
            if (currentPath.getParent().size() > 0) {
                this.index = app.random.nextInt(currentPath.getParent().size());
            }
        }
    }

    /**
     * Sets image for the monster.
     *
     * @param app the main app
     */
    public void setImage(App app) {
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
    }

    /**
     * Sets if the monster die.
     *
     * @param die the die
     */
    public void setDie(boolean die) {
        this.die = die;
    }

    /**
     * Sets hp of monster based on the damage.
     *
     * @param damage the damage
     */
    public void setHp(double damage) {
        this.hp = this.hp - damage * this.armour;
    }

    /**
     * Sets if the monster is accelerated.
     */
    public void setAccelerate() {
        if (App.IS_ACCELERATE) {
            speed = speed * 2;
        }
        else {
            speed = speed / 2;
        }
    }

    /**
     * Get the type of monster
     *
     * @return the type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get the hp of the monster
     *
     * @return the hp.
     */
    public double getHp() {
        return this.hp;
    }

    /**
     * Get the top hp of the monster
     *
     * @return the top hp.
     */
    public double getTopHp() {
        return topHp;
    }

    /**
     * Get the mana gained on killing the monster
     *
     * @return the mana
     */
    public double getManaGainedOnKill() {
        return this.manaGainedOnKill;
    }

    /**
     * Get the monster's living state.
     *
     * @return the monster's living state.
     */
    public boolean isDie() {
        return die;
    }

    /**
     * Get the x coordinate of monster
     *
     * @return the x coordinate of monster.
     */
    public float getX() {
        return this.x;
    }

    /**
     * Get the y coordinate of monster
     *
     * @return the y coordinate.
     */
    public float getY() {
        return y;
    }

    /**
     * Get the speed of monster
     *
     * @return the speed.
     */
    public float getSpeed() {
        return speed;
    }

    //    public void attack(App app) {
//        if (Math.abs(this.x - app.wizardHouse.getX() * App.CELLSIZE + App.TOPBAR) < )
//    }

    /**
     * Draw monster.
     *
     * @param app the main app
     */
    @Override
    public void draw(App app) {
        app.image(this.image, (float)y + (float) (App.CELLSIZE - this.image.width) / 2, (float)x + (float) (App.CELLSIZE - this.image.height) / 2);
    }

    /**
     * The motion of monster.
     *
     * @param app the main app
     */
    @Override
    public void move(App app) {
        if (currentPath.getDirection().get(index) == 0) {
            if (this.x >= (currentPath.getX() + 1) * App.CELLSIZE + App.TOPBAR) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        else if (currentPath.getDirection().get(index) == 1) {
            if (this.x <= (currentPath.getX() - 1) * App.CELLSIZE + App.TOPBAR) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        else if (currentPath.getDirection().get(index) == 2) {
            if (this.y >= (currentPath.getY() + 1) * App.CELLSIZE) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        else {
            if (this.y <= (currentPath.getY() - 1) * App.CELLSIZE) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        if (currentPath.getDirection().get(index) == 0) {
            this.x += speed;
        }
        else if (currentPath.getDirection().get(index) == 1) {
            this.x -= speed;
        }
        else if (currentPath.getDirection().get(index) == 2) {
            this.y += speed;
        }
        else if (currentPath.getDirection().get(index) == 3) {
            this.y -= speed;
        }
    }

    /**
     * If the monster dies, the monster death special effect is triggered.
     * Returns true when the special effect ends, otherwise returns false.
     *
     * @param app the main app
     * @return if the process is finish
     */
    public abstract boolean monsterDie(App app);

    @Override
    public void displayRect(App app) {
        app.stroke(app.color(252, 3, 3));
        app.fill(app.color(252, 3, 3));
        app.rect(this.getY() + (float) (App.CELLSIZE - this.image.width) / 2, this.getX() - 2, this.image.width, 2);
        if (this.hp >= 0) {
            app.stroke(app.color(3, 252, 57));
            app.fill(app.color(3, 252, 57));
            app.rect(this.getY() + (float) (App.CELLSIZE - this.image.width) / 2, this.getX() - 2, this.image.width * (float)(this.getHp() / this.getTopHp()), 2);
        }
    }

    @Override
    public void displayText(App app, int color) {

    }
}