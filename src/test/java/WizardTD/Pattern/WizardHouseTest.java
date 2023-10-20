package WizardTD.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import WizardTD.App;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class WizardHouseTest {
    /**
     * Method under test: {@link WizardHouse#WizardHouse(int, int)}
     */
    @Test
    void testConstructor() {
        WizardHouse actualWizardHouse = new WizardHouse(2, 3);

        assertEquals("wizard_house.png", actualWizardHouse.getType());
        assertEquals(3, actualWizardHouse.getY());
        assertEquals(2, actualWizardHouse.getX());
    }

    /**
     * Method under test: {@link WizardHouse#calculateHouseAngle(char[][], int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCalculateHouseAngle() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        WizardHouse wizardHouse = null;
        char[][] map = null;
        int i = 0;
        int j = 0;

        // Act
        double actualCalculateHouseAngleResult = wizardHouse.calculateHouseAngle(map, i, j);

        // Assert
        // TODO: Add assertions on result
    }
}

