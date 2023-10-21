package WizardTD.Button;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.Manager.Shape;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.Text;
import WizardTD.Manager.TextManager;

/**
 * This class used to define function of "M" button
 */
public class ManaPool extends Button{
    private int manaPoolSpellCost;
    private double manaPoolSpellCapMultiplier;
    private double manaPoolSpellGainedMultiplier;

    /**
     * Constructor: instantiates a new Mana pool button.
     *
     * @param x        the x coordinate of button
     * @param y        the y coordinate of button
     * @param size     the size of button
     * @param jsonInfo the json file info
     */
    public ManaPool(int x, int y, int size, JsonInfo jsonInfo) {
        super(x, y, size, "M", "Mana pool\n" + jsonInfo.getMana_pool_spell_initial_cost());
        this.manaPoolSpellCost = jsonInfo.getMana_pool_spell_initial_cost();
        this.manaPoolSpellCapMultiplier = jsonInfo.getMana_pool_spell_cap_multiplier();
        this.manaPoolSpellGainedMultiplier = jsonInfo.getMana_pool_spell_mana_gained_multiplier();
    }

    /**
     * Gets mana pool spell cost.
     *
     * @return the mana pool spell cost
     */
    public int getManaPoolSpellCost() {
        return manaPoolSpellCost;
    }

    /**
     * Gets mana pool spell cap multiplier.
     *
     * @return the mana pool spell cap multiplier
     */
    public double getManaPoolSpellCapMultiplier() {
        return manaPoolSpellCapMultiplier;
    }

    /**
     * Gets mana pool spell gained multiplier.
     *
     * @return the mana pool spell gained multiplier
     */
    public double getManaPoolSpellGainedMultiplier() {
        return manaPoolSpellGainedMultiplier;
    }

    /**
     * Update the mana pool spell cost by the info in json file.
     *
     * @param jsonInfo the json file info
     */
    public void updatePoolSpellCost(JsonInfo jsonInfo) {
        this.manaPoolSpellCost = this.manaPoolSpellCost + jsonInfo.getMana_pool_spell_cost_increase_per_use();
        this.describe = "Mana pool\n" + this.manaPoolSpellCost;
    }

    /**
     * Display the info box beside the "M" button
     *
     * @param shapeManager the shape manager
     * @param textManager  the shape manager
     */
    public void display(ShapeManager shapeManager, TextManager textManager) {
        shapeManager.addNewShape(new Shape(this.x - App.SIDEBAR, this.y, 96, 16, 1, App.WORD_COLOR, App.WHITE_COLOR, 1));
        textManager.addNewText(new Text("Cost: " + this.manaPoolSpellCost, this.x - App.SIDEBAR, this.y + 14, 13, App.WORD_COLOR));
    }

    /**
     * create the function of "M" button, update the mana bar.
     */
    @Override
    public void clickButton(App app) {
        if (app.manaBar.getProcess() > this.getManaPoolSpellCost()) {
            this.setUsing(true);
            app.manaBar.updateManaBar(this);
            this.updatePoolSpellCost(app.jsonInfo);
        }
    }
}
