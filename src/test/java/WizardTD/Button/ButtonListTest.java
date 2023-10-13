package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.JsonInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ButtonListTest {
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor() {
        new ButtonList(null);
    }

    @Test
    void testGetButtons() {
        assertEquals(11, (new ButtonList(new JsonInfo("/directory/foo.txt"))).getButtons().length);
    }
}

