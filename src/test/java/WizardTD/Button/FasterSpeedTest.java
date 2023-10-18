package WizardTD.Button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import WizardTD.App;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FasterSpeedTest {
    @Test
    void testConstructor() {
        FasterSpeed actualFasterSpeed = new FasterSpeed(2, 3, 3);

        assertEquals("2x speed", actualFasterSpeed.getDescribe());
        assertFalse(actualFasterSpeed.isUsing());
        assertEquals(3, actualFasterSpeed.getY());
        assertEquals(2, actualFasterSpeed.getX());
        assertEquals(3.0f, actualFasterSpeed.getSize());
        assertEquals("FF", actualFasterSpeed.getLabel());
    }
    @Test
    @Disabled("TODO: Complete this test")
    void testClickButton() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.clickButton(new App());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testClickButton2() {
        (new FasterSpeed(2, 3, 3)).clickButton(null);
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testClickButton3() {
        FasterSpeed fasterSpeed = new FasterSpeed(2, 3, 3);
        fasterSpeed.setUsing(true);
        fasterSpeed.clickButton(new App());
    }
}

