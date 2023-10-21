package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.JsonInfo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ButtonListTest {

    @Test
    void testGetButtons() {
        assertEquals(11, (new ButtonList(new JsonInfo("config.json"))).getButtons().length);
    }
}

