package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ShapeManagerTest {
    /**
     * Test addNewShape(Shape) method in ShapeManager.
     */
    @Test
    void testAddNewShape() {
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addNewShape(new Shape(1f, 1f, 1f, 1f, 1, 1, 1, 1f));
        assertEquals(1, shapeManager.getShapeList().size());
    }

    /**
     * Test popShape() method in ShapeManager.
     */
    @Test
    void testPopShape() {
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addNewShape(new Shape(1f, 1f, 1f, 1f, 1, 1, 1, 1f));
        shapeManager.popShape();
        assertEquals(0, shapeManager.getShapeList().size());
    }
}

