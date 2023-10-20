package WizardTD.Button;

import WizardTD.App;
import WizardTD.JsonInfo;
import WizardTD.ManaBar;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManaPoolTest {
    ManaPool manaPool = new ManaPool(2, 3, 3, new JsonInfo("config.json"));

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ManaPool#getManaPoolSpellCapMultiplier()}
     *   <li>{@link ManaPool#getManaPoolSpellCost()}
     *   <li>{@link ManaPool#getManaPoolSpellGainedMultiplier()}
     * </ul>
     */
    @Test
    void testGetter() {
        assertEquals(1.1d, manaPool.getManaPoolSpellGainedMultiplier());
        assertEquals(100, manaPool.getManaPoolSpellCost());
        assertEquals(1.5d, manaPool.getManaPoolSpellCapMultiplier());
    }

    /**
     * Method under test: {@link ManaPool#updatePoolSpellCost(JsonInfo)}
     */
    @Test
    void testUpdatePoolSpellCost() {
        manaPool.updatePoolSpellCost(new JsonInfo("config.json"));
        assertEquals("Mana pool\n250", manaPool.getDescribe());
        assertEquals(250, manaPool.getManaPoolSpellCost());
    }

    /**
     * Method under test: {@link ManaPool#display(App)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDisplay() {
        ManaPool manaPool = new ManaPool(2, 3, 3, new JsonInfo("config.json"));
        manaPool.display(new App());
    }

    /**
     * Method under test: {@link ManaPool#clickButton(App)}
     */
    @Test
    void testClickButton() {
        manaPool = new ManaPool(2, 3, 3, new JsonInfo("config.json"));
        App app = new App();
        app.jsonInfo = new JsonInfo("config.json");
        app.manaBar = new ManaBar(1, 1, 20, "", app);
        app.manaBar.setProcess(90);
        manaPool.clickButton(app);
        assertFalse(manaPool.isUsing());
        assertEquals(90, app.manaBar.getProcess());
        assertEquals(100, manaPool.getManaPoolSpellCost());
        assertEquals(1000, app.manaBar.getManaCap());
        assertEquals(2f, app.manaBar.getGainedSpeed());
        app.manaBar.setProcess(101);
        manaPool.clickButton(app);
        assertTrue(manaPool.isUsing());
        assertEquals(1, app.manaBar.getProcess());
        assertEquals(250, manaPool.getManaPoolSpellCost());
        assertEquals(1500, app.manaBar.getManaCap());
        assertEquals(2.2f, app.manaBar.getGainedSpeed());
    }
}

