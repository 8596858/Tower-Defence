package WizardTD;

import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.Text;
import WizardTD.Manager.TextManager;

/**
 * The type show wave.
 */
public class ShowWave implements Display{
    private int x;
    private int y;
    private int wave;
    private double duration;
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

    /**
     * Add the shape the represent the wave into the shape manager.
     *
     * @param app the app
     * @param shapeManager the shape manager
     */
    @Override
    public void addShape(App app, ShapeManager shapeManager) {

    }

    /**
     * Add the text the represent the index and remaining duration of the wave into the text manager.
     *
     * @param app the app
     * @param textManager the text manager
     */
    @Override
    public void addText(App app, TextManager textManager) {
        textManager.addNewText(new Text("Wave " + (this.wave + 2) + " " + "Start " + (int)this.duration, this.x, this.y, 20, App.WORD_COLOR));
        this.duration = this.duration - 1 / (double)App.FPS * this.speed;
    }
}
