package WizardTD;

import WizardTD.Monster.Monster;
import processing.core.PImage;

/**
 * The type Fireball.
 */
public class FireBall implements Effect{
    /**
     * The speed of fireball.
     */
    public static float SPEED = 5f;
    private String type;
    private double damage;
    private PImage image;
    private Monster target;
    private float x;
    private float y;
    private boolean finish;

    /**
     * Constructor: instantiates a new Fireball.
     *
     * @param x      the x coordinate of fireball.
     * @param y      the y coordinate of fireball.
     * @param app    the app
     * @param damage the damage.
     * @param target the target of fireball.
     */
    public FireBall(float x, float y, App app, double damage, Monster target) {
        this.x = x * App.CELLSIZE + App.TOPBAR + (float) App.CELLSIZE / 2;
        this.y = y * App.CELLSIZE + (float) App.CELLSIZE / 2;
        this.damage = damage;
        this.type = "fireball.png";
        this.image = app.loadImage("src/main/resources/WizardTD/" + this.type);
        this.target = target;
        this.finish = false;
    }

    /**
     * Is finish boolean.
     *
     * @return if the fireball is finish
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * Sets acceleration.
     */
    public static void setAccelerate() {
        if (App.IS_ACCELERATE) {
            SPEED = SPEED * 2;
        }
        else {
            SPEED = SPEED / 2;
        }
    }

    /**
     * Draw fireball.
     *
     * @param app the main app
     */
    @Override
    public void draw(App app) {
        app.image(this.image, y - (float) this.image.width / 2, x - (float) this.image.height / 2);
    }

    /**
     * The motion of fireball.
     *
     * @param app the main app
     */
    @Override
    public void move(App app) {
        float distance = (float) Math.sqrt((target.getX() + (double) App.CELLSIZE / 2 - this.x) * (target.getX() + (double) App.CELLSIZE / 2 - this.x)
                + (target.getY() + (double) App.CELLSIZE / 2 - this.y) * (target.getY() + (double) App.CELLSIZE / 2 - this.y));
        this.x = (float) (this.x + (target.getX() + (double) App.CELLSIZE / 2  - this.x) / distance * SPEED);
        this.y = (float) (this.y + (target.getY() + (double) App.CELLSIZE / 2 - this.y) / distance * SPEED);
        if (distance < (float) App.CELLSIZE) {
            finish = true;
            target.setHp(damage);
        }
        draw(app);
    }
}
