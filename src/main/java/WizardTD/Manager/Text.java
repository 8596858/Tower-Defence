package WizardTD.Manager;

/**
 * The type Text store the texts will display int the game.
 */
public class Text {
    private String content;
    private float x;
    private float y;
    private int size;
    private int color;

    /**
     * Constructor: instantiates a new Text.
     *
     * @param content the content of text
     * @param x       the x coordinate of text
     * @param y       the y coordinate of text
     * @param size    the size of text
     * @param color   the color of text
     */
    public Text(String content, float x, float y, int size, int color) {
        this.content = content;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * Gets content of text.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Gets x coordinate of text.
     *
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * Gets y coordinate of text.
     *
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * Gets size of text.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets color of text.
     *
     * @return the color
     */
    public int getColor() {
        return color;
    }
}
