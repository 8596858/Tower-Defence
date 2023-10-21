package WizardTD;

import processing.data.JSONObject;
import processing.data.JSONArray;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * The type Json file info.
 */
public class JsonInfo {
    private String layout;
    private JSONArray waves;
    private int initial_tower_range;
    private double initial_tower_firing_speed;
    private int initial_tower_damage;
    private int initial_mana;
    private int initial_mana_cap;
    private int initial_mana_gained_per_second;
    private int tower_cost;
    private int mana_pool_spell_initial_cost;
    private int mana_pool_spell_cost_increase_per_use;
    private double mana_pool_spell_cap_multiplier;
    private double mana_pool_spell_mana_gained_multiplier;

    /**
     * Constructor: instantiates a new Json info.
     *
     * @param filePath the file path
     */
    public JsonInfo(String filePath) {
        try {
            Reader reader = new FileReader(filePath);
            JSONObject jsonObject = new JSONObject(reader);
            this.layout = jsonObject.getString("layout");
            this.initial_tower_range = jsonObject.getInt("initial_tower_range");
            this.initial_tower_firing_speed = jsonObject.getDouble("initial_tower_firing_speed");
            this.initial_tower_damage = jsonObject.getInt("initial_tower_damage");
            this.initial_mana = jsonObject.getInt("initial_mana");
            this.initial_mana_cap = jsonObject.getInt("initial_mana_cap");
            this.initial_mana_gained_per_second = jsonObject.getInt("initial_mana_gained_per_second");
            this.tower_cost = jsonObject.getInt("tower_cost");
            this.mana_pool_spell_initial_cost = jsonObject.getInt("mana_pool_spell_initial_cost");
            this.mana_pool_spell_cost_increase_per_use = jsonObject.getInt("mana_pool_spell_cost_increase_per_use");
            this.mana_pool_spell_cap_multiplier = jsonObject.getDouble("mana_pool_spell_cap_multiplier");
            this.mana_pool_spell_mana_gained_multiplier = jsonObject.getDouble("mana_pool_spell_mana_gained_multiplier");
            this.waves = jsonObject.getJSONArray("waves");
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets layout of a level of game.
     *
     * @return the layout
     */
    public String getLayout() {
        return this.layout;
    }

    /**
     * Gets waves in the game.
     *
     * @return the waves
     */
    public JSONArray getWaves() {
        return this.waves;
    }

    /**
     * Gets initial tower range.
     *
     * @return the initial tower range
     */
    public int getInitial_tower_range() {
        return this.initial_tower_range;
    }

    /**
     * Gets initial tower firing speed.
     *
     * @return the initial tower firing speed
     */
    public double getInitial_tower_firing_speed() {
        return this.initial_tower_firing_speed;
    }

    /**
     * Gets initial tower damage.
     *
     * @return the initial tower damage
     */
    public int getInitial_tower_damage() {
        return this.initial_tower_damage;
    }

    /**
     * Gets initial mana in the mana pool.
     *
     * @return the initial mana
     */
    public int getInitial_mana() {
        return this.initial_mana;
    }

    /**
     * Gets initial mana cap of the mana pool.
     *
     * @return the initial mana cap
     */
    public int getInitial_mana_cap() {
        return this.initial_mana_cap;
    }

    /**
     * Gets initial mana gained per second.
     *
     * @return the initial mana gained per second
     */
    public int getInitial_mana_gained_per_second() {
        return this.initial_mana_gained_per_second;
    }

    /**
     * Gets initial tower cost.
     *
     * @return the tower cost
     */
    public int getTower_cost() {
        return this.tower_cost;
    }

    /**
     * Gets mana pool spell initial cost.
     *
     * @return the mana pool spell initial cost
     */
    public int getMana_pool_spell_initial_cost() {
        return this.mana_pool_spell_initial_cost;
    }

    /**
     * Gets mana pool spell cost increase per use.
     *
     * @return the mana pool spell cost increase per use
     */
    public int getMana_pool_spell_cost_increase_per_use() {
        return this.mana_pool_spell_cost_increase_per_use;
    }

    /**
     * Gets mana pool spell cap multiplier.
     *
     * @return the mana pool spell cap multiplier
     */
    public double getMana_pool_spell_cap_multiplier() {
        return this.mana_pool_spell_cap_multiplier;
    }

    /**
     * Gets mana pool spell mana gained multiplier.
     *
     * @return the mana pool spell mana gained multiplier
     */
    public double getMana_pool_spell_mana_gained_multiplier() {
        return this.mana_pool_spell_mana_gained_multiplier;
    }
}
