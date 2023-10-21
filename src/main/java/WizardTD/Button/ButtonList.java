package WizardTD.Button;

import WizardTD.App;
import WizardTD.JsonInfo;

/**
 * This class manage the function of buttons.
 * It can set up seven buttons with different usage.
 */
public class ButtonList {

    private final Button[] buttons;

    /**
     * Constructor: instantiates a new button list.
     *
     * @param jsonInfo the json file info
     */
    public ButtonList(JsonInfo jsonInfo) {
        buttons = new Button[11];
        buttons[0] = new FasterSpeed(App.WIDTH - 110, App.TOPBAR + 40, 45);
        buttons[1] = new Pause(App.WIDTH - 110, App.TOPBAR + 100, 45);
        buttons[2] = new PutTower(App.WIDTH - 110, App.TOPBAR + 160, 45);
        buttons[3] = new UpdateRange(App.WIDTH - 110, App.TOPBAR + 220, 45);
        buttons[4] = new UpdateSpeed(App.WIDTH - 110, App.TOPBAR + 280, 45);
        buttons[5] = new UpdateDamage(App.WIDTH - 110, App.TOPBAR + 340, 45);
        buttons[6] = new ManaPool(App.WIDTH - 110, App.TOPBAR + 400, 45, jsonInfo);
        buttons[7] = new Level1(App.WIDTH / 9, App.TOPBAR + 220, 45);
        buttons[8] = new Level2(App.WIDTH * 3 / 9, App.TOPBAR + 220, 45);
        buttons[9] = new Level3(App.WIDTH * 5 / 9, App.TOPBAR + 220, 45);
        buttons[10] = new Level4(App.WIDTH * 7 / 9, App.TOPBAR + 220, 45);
    }

    /**
     * Get the buttons.
     *
     * @return the button array
     */
    public Button[] getButtons() {
        return buttons;
    }
}
