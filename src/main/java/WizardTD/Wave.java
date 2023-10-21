package WizardTD;

import processing.data.JSONArray;
import processing.data.JSONObject;

/**
 * The type Wave.
 */
public class Wave {
    private double duration;
    private double preWavePause;
    private JSONArray monsters;

    /**
     * Constructor: instantiates a new Wave.
     *
     * @param jsonObject the json object
     */
    public Wave(JSONObject jsonObject) {
        this.duration = jsonObject.getDouble("duration");
        this.preWavePause = jsonObject.getDouble("pre_wave_pause");
        this.monsters = jsonObject.getJSONArray("monsters");
    }

    /**
     * Gets duration of a wave.
     *
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Gets the time that the wave have to wait after the monster manager finish generate the monster.
     *
     * @return the pre wave pause
     */
    public double getPreWavePause() {
        return preWavePause;
    }

    /**
     * Gets monsters info.
     *
     * @return the monsters
     */
    public JSONArray getMonsters() {
        return monsters;
    }
}
