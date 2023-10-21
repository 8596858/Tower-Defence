package WizardTD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class JsonInfoTest {
    @Test
    void testConstructor() {
        JsonInfo jsonInfo = new JsonInfo("config.json");
        assertEquals(200, jsonInfo.getInitial_mana());
        assertEquals(3, jsonInfo.getWaves().size());
        assertEquals(100, jsonInfo.getTower_cost());
        assertEquals(1.1d, jsonInfo.getMana_pool_spell_mana_gained_multiplier());
        assertEquals(100, jsonInfo.getMana_pool_spell_initial_cost());
        assertEquals(150, jsonInfo.getMana_pool_spell_cost_increase_per_use());
        assertEquals(1.5d, jsonInfo.getMana_pool_spell_cap_multiplier());
        assertEquals("level0.txt", jsonInfo.getLayout());
        assertEquals(96, jsonInfo.getInitial_tower_range());
        assertEquals(1.5d, jsonInfo.getInitial_tower_firing_speed());
        assertEquals(40, jsonInfo.getInitial_tower_damage());
        assertEquals(2, jsonInfo.getInitial_mana_gained_per_second());
        assertEquals(1000, jsonInfo.getInitial_mana_cap());
    }
}

