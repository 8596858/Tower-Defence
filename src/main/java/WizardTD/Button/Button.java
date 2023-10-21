package WizardTD.Button;

import WizardTD.App;
import WizardTD.Display;
import WizardTD.Manager.Shape;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.Text;
import WizardTD.Manager.TextManager;

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
     * @param x        the x coordinate of button
     * @param y        the y coordinate of button
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
     * Gets x coordinate of button.
     *
     * @return the value of x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y coordinate of button.
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
     * This method used to add the shapes to the shape manager that will display in the panel.
     */
    @Override
    public void addShape(App app, ShapeManager shapeManager) {
        int fillColor = 0;
        if (isUsing) {
            fillColor = App.BUTTON_COLOR;
        }
        else if (app.mouseInButton(app.buttonList.getButtons()) != -1) {
            if (app.buttonList.getButtons()[app.mouseInButton(app.buttonList.getButtons())].getLabel().matches(this.label) && !App.PAUSE) {
                fillColor = 0x828282;
            }
            else {
                fillColor = App.BAR_COLOR;
            }
        }
        else {
            fillColor = App.BAR_COLOR;
        }
        shapeManager.addNewShape(new Shape(this.getX(), this.getY(), this.getSize(), this.getSize(), 1, App.WORD_COLOR, fillColor, 1));
    }

    /**
     * This method used to add the texts to the text manager that will display in the panel.
     */
    @Override
    public void addText(App app, TextManager textManager) {
        textManager.addNewText(new Text(this.getLabel(), this.getX() + this.getSize() / 4,
                this.getY() + this.getSize() / 2,20, App.WORD_COLOR));
        textManager.addNewText(new Text(this.getDescribe(), this.getX() + this.getSize() * 1.1f,
                this.getY() + this.getSize() / 2,12, App.WORD_COLOR));
    }

    /**
     * Click button to activate event.
     *
     * @param app the main app
     */
    public abstract void clickButton(App app);
}
