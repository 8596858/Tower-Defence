package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TextManagerTest {
    /**
     * Test addNewText(Text) method in TextManager.
     */
    @Test
    void testAddNewText() {
        TextManager textManager = new TextManager();
        textManager.addNewText(new Text("text", 1f, 1f, 3, 1));
        assertEquals(1, textManager.getTextList().size());
    }

    /**
     * Test popText() method in TextManager.
     */
    @Test
    void testPopText() {
        TextManager textManager = new TextManager();
        textManager.addNewText(new Text("text", 1f, 1f, 3, 1));
        textManager.popText();
        assertEquals(0, textManager.getTextList().size());
    }
}

