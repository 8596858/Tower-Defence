package WizardTD.Manager;

/**
 * The type Shape is used to store the information of the shape in the map.
 */
public class Shape {
    private float a;
    private float b;
    private float c;
    private float d;
    private int type;
    private int strokeColor;
    private int fillColor;
    private float alpha;

    /**
     * Constructor: instantiates a new Shape.
     *
     * @param a the y location
     * @param b the x location
     * @param c the width of shape
     * @param d the height of shape
     * @param type the type of shape
     * @param strokeColor the stroke color of shape
     * @param fillColor the fill color of shape
     */
    public Shape(float a, float b, float c, float d, int type, int strokeColor, int fillColor, float alpha) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.type = type;
        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
        this.alpha = alpha;
    }

    /**
     * Gets y location.
     *
     * @return the a
     */
    public float getA() {
        return a;
    }

    /**
     * Gets x location.
     *
     * @return the b
     */
    public float getB() {
        return b;
    }

    /**
     * Gets the width of shape.
     *
     * @return the c
     */
    public float getC() {
        return c;
    }

    /**
     * Gets the height of shape.
     *
     * @return the d
     */
    public float getD() {
        return d;
    }

    /**
     * Gets the type of shape.
     *
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * Gets the stroke color of shape.
     *
     * @return the strokeColor
     */
    public int getStrokeColor() {
        return strokeColor;
    }

    /**
     * Gets the fill color of shape.
     *
     * @return the fillColor
     */
    public int getFillColor() {
        return fillColor;
    }

    /**
     * Gets alpha of the shape.
     *
     * @return the alpha
     */
    public float getAlpha() {
        return alpha;
    }
}
