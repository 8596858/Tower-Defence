package WizardTD.Manager;

import java.util.Stack;

/**
 * The type shape manager manage the shapes in the map
 */
public class ShapeManager {
    private Stack<Shape> shapeList;

    /**
     * Constructor: instantiates a new Shape manager.
     */
    public ShapeManager() {
        this.shapeList = new Stack<>();
    }

    /**
     * Gets shape stack list.
     *
     * @return the shape stack list
     */
    public Stack<Shape> getShapeList() {
        return shapeList;
    }

    /**
     * Add new shape to the stack.
     *
     * @param shape the shape
     */
    public void addNewShape(Shape shape) {
        shapeList.add(shape);
    }

    /**
     * Pop shape from the stack.
     *
     * @return the shape
     */
    public Shape popShape() {
        return shapeList.pop();
    }
}
