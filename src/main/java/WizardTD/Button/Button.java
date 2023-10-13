package WizardTD.Button;

import WizardTD.App;
import WizardTD.Display;

/**
 * This abstract class is used to extend different kind of buttons.
 * It can be used to define the size and position of the button
 * It can display the button
 */
public abstract class Button implements Display {

    /**
     * x coordination of button
     */
    protected int x;

    /**
     * y coordination of button
     */
    protected int y;

    /**
     * size of button
     */
    protected float size;

    /**
     * label of button
     */
    protected String label;

    /**
     * description of button
     */
    protected String describe;

    /**
     * if the button is using
     */
    protected boolean isUsing;

    /**
     * Constructor: instantiates a new button.
     *
     * @param x        the x coordinate
     * @param y        the y coordinate
     * @param size     the size of button
     * @param label    the label of button
     * @param describe the description of button
     */
    public Button(int x, int y, int size, String label, String describe) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.label = label;
        this.describe = describe;
        this.isUsing = false;
    }

    /**
     * Gets x coordinate.
     *
     * @return the value of x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y coordinate.
     *
     * @return the value of y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Gets size of button.
     *
     * @return the size of button
     */
    public float getSize() {
        return size;
    }

    /**
     * Gets start x coordinate of button.
     *
     * @return the start x coordinate of button.
     */
    public int getStartX() {
        return this.x;
    }

    /**
     * Gets end x coordinate of button.
     *
     * @return the end x coordinate of button.
     */
    public int getEndX() {
        return (int)(this.x + this.size);
    }

    /**
     * Gets start y coordinate of button.
     *
     * @return the start y coordinate of button.
     */
    public int getStartY() {
        return this.y;
    }

    /**
     * Gets end y coordinate of button.
     *
     * @return the end y coordinate of button.
     */
    public int getEndY() {
        return (int)(this.y + this.size);
    }

    /**
     * Gets description of button.
     *
     * @return description of button
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * Gets label of button.
     *
     * @return the label of button
     */
    public String getLabel() {
        return label;
    }

    /**
     * Determine state of using.
     *
     * @return the state of using
     */
    public boolean isUsing() {
        return isUsing;
    }

    /**
     * Set the state of using.
     *
     * @param using the using state of button
     */
    public void setUsing(boolean using) {
        isUsing = using;
    }

    /**
     * This method used to display the shape of the button
     */
    @Override
    public void displayRect(App app) {
        app.stroke(App.WORD_COLOR);
        if (isUsing) {
            app.fill(App.BUTTON_COLOR);
        }
        else if (app.mouseInButton(app.buttonList.getButtons()) != -1) {
            if (app.buttonList.getButtons()[app.mouseInButton(app.buttonList.getButtons())].getLabel().matches(this.label)) {
                app.fill(app.color(130, 130, 130));
            }
            else {
                app.fill(App.BAR_COLOR);
            }
        }
        else {
            app.fill(App.BAR_COLOR);
        }
        app.rect(this.getX(), this.getY(), this.getSize(), this.getSize());
    }

    /**
     * This method used to display the text info of the button
     */
    @Override
    public void displayText(App app, int color) {
        app.fill(App.WORD_COLOR);
        app.textSize(20);
        app.text(this.getLabel(), this.getX() + (float) this.getSize() / 4f, this.getY() + (float) this.getSize() / 2f);
        app.textSize(10);
        app.text(this.getDescribe(), this.getX() + (float) this.getSize() * 1.1f, this.getY() + (float) this.getSize() / 2f);
    }

    /**
     * This method used to display the button
     * Every button is the same
     *
     * @param app       the main app
     * @param wordColor the word color
     */
    public void displayButton(App app, int wordColor) {
        displayRect(app);
        displayText(app, wordColor);
    }

    /**
     * Click button to activate event.
     *
     * @param app the main app
     */
    public abstract void clickButton(App app);
}
