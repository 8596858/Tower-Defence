package WizardTD;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import processing.data.JSONArray;
import processing.data.JSONObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaveTest {
    @Test
    void testConstructor() {
        JsonInfo jsonInfo = new JsonInfo("config.json");
        Wave wave = new Wave(jsonInfo.getWaves().getJSONObject(0));
        assertEquals(8, wave.getDuration());
        assertEquals(0.5, wave.getPreWavePause());
        assertEquals(1, wave.getMonsters().size());
    }
}

