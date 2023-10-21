package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShapeManagerTest {
    /**
     * Method under test: {@link ShapeManager#addNewShape(Shape)}
     */
    @Test
    void testAddNewShape() {
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addNewShape(new Shape(10f, 10f, 10f, 10f, 1, 1, 1, 10f));
        assertEquals(1, shapeManager.getShapeList().size());
    }

    /**
     * Method under test: {@link ShapeManager#popShape()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPopShape() {
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addNewShape(new Shape(10f, 10f, 10f, 10f, 1, 1, 1, 10f));
        shapeManager.popShape();
        assertEquals(0, shapeManager.getShapeList().size());
    }
}

