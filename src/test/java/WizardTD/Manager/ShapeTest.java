package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ShapeTest {
    /**
     * Method under test: {@link Shape#Shape(float, float, float, float, int, int, int, float)}
     */
    @Test
    void testGetter() {
        Shape actualShape = new Shape(10f, 10f, 10f, 10f, 1, 1, 1, 1f);

        assertEquals(10f, actualShape.getA());
        assertEquals(10f, actualShape.getD());
        assertEquals(10f, actualShape.getC());
        assertEquals(10f, actualShape.getB());
        assertEquals(1, actualShape.getType());
        assertEquals(1, actualShape.getStrokeColor());
        assertEquals(1, actualShape.getFillColor());
        assertEquals(1f, actualShape.getAlpha());
    }
}

