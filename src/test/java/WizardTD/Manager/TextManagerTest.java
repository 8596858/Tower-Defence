package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TextManagerTest {
    @Test
    void testAddNewText() {
        TextManager textManager = new TextManager();
        textManager.addNewText(new Text("text", 1f, 1f, 3, 1));
        assertEquals(1, textManager.getTextList().size());
    }

    @Test
    void testPopText() {
        TextManager textManager = new TextManager();
        textManager.addNewText(new Text("text", 1f, 1f, 3, 1));
        textManager.popText();
        assertEquals(0, textManager.getTextList().size());
    }
}

