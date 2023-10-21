package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShapeManagerTest {
    @Test
    void testAddNewShape() {
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addNewShape(new Shape(1f, 1f, 1f, 1f, 1, 1, 1, 1f));
        assertEquals(1, shapeManager.getShapeList().size());
    }

    @Test
    void testPopShape() {
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addNewShape(new Shape(1f, 1f, 1f, 1f, 1, 1, 1, 1f));
        shapeManager.popShape();
        assertEquals(0, shapeManager.getShapeList().size());
    }
}

