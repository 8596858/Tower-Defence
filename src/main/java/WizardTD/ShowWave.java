package WizardTD;

/**
 * The type Show wave.
 */
public class ShowWave implements Display{
    private int x;
    private int y;
    private int wave;
    private double duration;
    private int timer;
    private int speed;

    /**
     * Constructor: instantiates a new ShowWave.
     *
     * @param x        the x coordinate
     * @param y        the y coordinate
     * @param wave     the wave
     * @param duration the duration
     */
    public ShowWave(int x, int y, int wave, double duration) {
        this.x = x;
        this.y = y;
        this.wave = wave;
        this.duration = duration;
        this.timer = 0;
        this.speed = 1;
    }

    /**
     * Gets duration of a wave.
     *
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Gets speed of a wave going.
     *
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets current wave.
     *
     * @param wave the wave
     */
    public void setWave(int wave) {
        this.wave = wave;
    }

    /**
     * Sets duration of a wave.
     *
     * @param duration the duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * Sets speed of wave going.
     *
     * @param speed the speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void displayRect(App app) {

    }

    @Override
    public void displayText(App app, int color) {
        app.fill(app.color(color));
        app.textSize(20);
        app.text("Wave " + (this.wave + 2) + " " + "Start " + (int)this.duration, this.x, this.y);
        this.duration = this.duration - 1 / (double)App.FPS * this.speed;
    }
}
