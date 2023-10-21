package WizardTD.Manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TextManagerTest {

    /**
     * Method under test: {@link TextManager#addNewText(Text)}
     */
    @Test
    void testAddNewText() {
        TextManager textManager = new TextManager();
        textManager.addNewText(new Text("text", 1f, 1f, 3, 1));
        assertEquals(1, textManager.getTextList().size());
    }

    /**
     * Method under test: {@link TextManager#popText()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPopText() {
        TextManager textManager = new TextManager();
        textManager.addNewText(new Text("text", 1f, 1f, 3, 1));
        textManager.popText();
        assertEquals(0, textManager.getTextList().size());
    }
}

