package WizardTD;

import WizardTD.Button.ManaPool;
import WizardTD.Manager.Shape;
import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.Text;
import WizardTD.Manager.TextManager;
import WizardTD.Monster.Monster;
import WizardTD.Pattern.Tower;

/**
 * The type Mana bar.
 */
public class ManaBar implements Display{
    private int x;
    private int y;
    private float manaCap;
    private float width;
    private float process;
    private float gainedSpeed;
    private String label;

    /**
     * Constructor: instantiates a new mana bar.
     *
     * @param x     the x coordinate of mana bar.
     * @param y     the y coordinate of mana bar.
     * @param width the width of mana bar.
     * @param label the label of mana bar.
     * @param app   the main app
     */
    public ManaBar(int x, int y, int width, String label, App app) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.label = label;
        this.process = (float)app.jsonInfo.getInitial_mana();
        this.gainedSpeed = (float)app.jsonInfo.getInitial_mana_gained_per_second();
        this.manaCap = (float)app.jsonInfo.getInitial_mana_cap();
    }

    /**
     * Gets x coordinate of mana bar.
     *
     * @return the x coordinate of mana bar
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y coordinate of mana bar.
     *
     * @return the y coordinate of mana bar
     */
    public int getY() {
        return y;
    }

    /**
     * Gets gained speed of mana.
     *
     * @return speed
     */
    public float getGainedSpeed() {
        return gainedSpeed;
    }

    /**
     * Gets mana cap of mana bar.
     *
     * @return the mana cap
     */
    public float getManaCap() {
        return manaCap;
    }

    /**
     * Gets width of mana bar.
     *
     * @return the width of mana bar
     */
    public float getWidth() {
        return width;
    }

    /**
     * Gets process of mana bar.
     *
     * @return the process of mana bar
     */
    public float getProcess() {
        return process;
    }

    /**
     * Gets label of mana bar.
     *
     * @return the label of mana bar
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets process of mana bar.
     *
     * @param process the process of mana bar
     */
    public void setProcess(float process) {
        this.process = process;
    }

    /**
     * Update process of mana bar.
     *
     * @param addTower the flag of adding tower
     */
    public void updateProcess(boolean addTower) {
        if (addTower) {
            this.process = this.process - Tower.TOWER_COST;
        }
        if (this.process < this.manaCap) {
            if (!App.IS_ACCELERATE) {
                this.process = this.process + this.gainedSpeed / App.FPS;
            }
            else {
                this.process = this.process + this.gainedSpeed * 2 / App.FPS;
            }
        }
        else {
            this.process = this.manaCap;
        }
    }

    /**
     * Update process of mana bar.
     *
     * @param cost the cost of updating or adding tower.
     */
    public void updateProcess(int cost) {
        this.process = this.process - cost;
    }

    /**
     * If the monster attack the wizard house, the mana pool will lose the mana depending on the monster hp.
     *
     * @param monster the monster which attack the wizard house.
     */
    public void beAttacked(Monster monster) {
        this.process = (float) (this.process - monster.getHp());
    }

    /**
     * Add mana by kill the monster.
     *
     * @param monster the monster been killed
     */
    public void addMonsterMana(Monster monster) {
        if (this.process < this.manaCap) {
            this.process = (float) (this.process + monster.getManaGainedOnKill());
        }
    }

    /**
     * Update mana bar.
     *
     * @param manaPool the mana pool
     */
    public void updateManaBar(ManaPool manaPool) {
        this.gainedSpeed = (float) (this.gainedSpeed * manaPool.getManaPoolSpellGainedMultiplier());
        this.manaCap = (float) (this.manaCap * manaPool.getManaPoolSpellCapMultiplier());
        this.process = this.process - manaPool.getManaPoolSpellCost();
    }

    /**
     * Add the shape the represent the remaining and cap of the mana into the shape manager.
     *
     * @param app the app
     * @param shapeManager the shape manager
     */
    @Override
    public void addShape(App app, ShapeManager shapeManager) {
        if (this.getProcess() >= 0) {
            shapeManager.addNewShape(new Shape(this.getX(), this.getY(), this.getProcess() / this.getManaCap() * 200, this.getWidth(),
                    1, App.WORD_COLOR, App.PROCESS_COLOR, 1));
        }
        shapeManager.addNewShape(new Shape(this.getX(), this.getY(), 200, this.getWidth(),
                1, App.WORD_COLOR, App.WHITE_COLOR, 1));
    }

    /**
     * Add the text the represent the remaining and cap of the mana into the text manager.
     *
     * @param app the app
     * @param textManager the text manager
     */
    @Override
    public void addText(App app, TextManager textManager) {
        textManager.addNewText(new Text(this.getLabel(), this.getX() - 50, this.getY() + 20, 15, App.WORD_COLOR));
        textManager.addNewText(new Text(String.format("%.0f", this.getProcess()) + " / " + String.format("%.0f", this.getManaCap()), this.getX() + this.getWidth() * 1.5f, this.getY() + this.getWidth() / 1.5f, 15, App.WORD_COLOR));
    }

    /**
     * Add the shapes and texts into the manager.
     *
     * @param app           the main app
     * @param shapeManager  the shape manager
     */
    public void display(App app, ShapeManager shapeManager, TextManager textManager) {
        addShape(app, shapeManager);
        addText(app, textManager);
    }
}
