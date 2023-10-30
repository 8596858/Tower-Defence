package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TextTest {
    /**
     * Test getter methods in Text.
     */
    @Test
    void testGetter() {
        Text actualText = new Text("text", 10f, 10f, 3, 1);
        int actualColor = actualText.getColor();
        String actualContent = actualText.getContent();
        int actualSize = actualText.getSize();
        float actualX = actualText.getX();
        assertEquals(1, actualColor);
        assertEquals("text", actualContent);
        assertEquals(3, actualSize);
        assertEquals(10f, actualX);
        assertEquals(10f, actualText.getY());
    }
}

