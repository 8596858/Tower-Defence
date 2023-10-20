package WizardTD.Manager;

import WizardTD.App;
import WizardTD.Monster.Beetle;
import WizardTD.Monster.Gremlin;
import WizardTD.Monster.Monster;
import WizardTD.Monster.Worm;
import processing.data.JSONObject;

import java.util.ArrayList;

/**
 * This class is used to manage the monster in the game.
 * It will be used to control the generation and death of the monster
 */
public class MonsterManager extends Manager<Monster> {
    /**
     * MONSTERS_INDEX is the index of the set of monsters in a wave
     */
    public static int MONSTERS_INDEX = 0;
    /**
     * MONSTER_INDEX is the index of the monster in a monster set
     */
    public static int MONSTER_INDEX = 0;
    private JSONObject monsterObject;

    /**
     * Constructor: instantiates a new Monster manager.
     *
     * @param app the app
     */
    public MonsterManager(App app) {
        super();
        MONSTERS_INDEX = 0;
        MONSTER_INDEX = 0;
        monsterObject = app.waves[App.WAVE_INDEX + 1].getMonsters().getJSONObject(MONSTERS_INDEX);
    }

    /**
     * @return the monsters
     */
    public ArrayList<Monster> getMonsters() {
        return list;
    }

    /**
     * This method is used to update the state of the monsters
     * It will identify if the monster has to die or move.
     */
    @Override
    public void update(App app) {
        for (int i = 0; i < list.size();) {
            if (list.get(i).getHp() <= 0) {
                list.get(i).setDie(true);
                if (list.get(i).monsterDie(app)) {
                    app.manaBar.addMonsterMana(list.get(i));
                    list.remove(i);
                }
                else {
                    i++;
                }
            }
            else {
                list.get(i).move(app);
                i++;
            }
        }
    }

    /**
     * This method is used to update the time interval of the monster generation
     *
     * @param app   the app
     * @param index the index
     */
    public void updateTimeInterval(App app, int index) {
        double total = 0;
        for (int i = 0; i < app.waves[index].getMonsters().size(); i++) {
            JSONObject tempObject = app.waves[index].getMonsters().getJSONObject(i);
            total += tempObject.getInt("quantity");
        }
        Monster.TIME_INTERVAL = app.waves[index].getDuration() / total;
        if (App.IS_ACCELERATE) {
            Monster.TIME_INTERVAL = Monster.TIME_INTERVAL / 2;
        }
    }

    /**
     * Sets if the monster is accelerated.
     */
    public void setAccelerate() {
        for (Monster monster : list) {
            monster.setAccelerate();
        }
    }

    /**
     * This method is used to generate the monster in the map
     */
    @Override
    public void generate(App app) {
        if (App.WAVE_INDEX == -1) {
            if (app.showWave.getDuration() <= 0) {
                App.WAVE_INDEX++;
                app.showWave.setWave(App.WAVE_INDEX);
                if (App.WAVE_INDEX < app.waves.length - 1) {
                    app.showWave.setDuration((int)app.waves[App.WAVE_INDEX].getDuration() + (int)app.waves[App.WAVE_INDEX + 1].getPreWavePause());
                }
                updateTimeInterval(app, App.WAVE_INDEX);
            }
        }
        else {
            if (System.currentTimeMillis() - App.CURRENT_TIME >= Monster.TIME_INTERVAL * 1000 * 60 / App.FPS) {
                if (MONSTER_INDEX < monsterObject.getDouble("quantity")) {
                    if (monsterObject.getString("type").matches("gremlin")) {
                        list.add(new Gremlin(app.paths.getStartPoints().get(app.random.nextInt(app.paths.getStartPoints().size())), app, monsterObject));
                    }
                    else if (monsterObject.getString("type").matches("beetle")) {
                        list.add(new Beetle(app.paths.getStartPoints().get(app.random.nextInt(app.paths.getStartPoints().size())), app, monsterObject));
                    }
                    else if (monsterObject.getString("type").matches("Worm")) {
                        list.add(new Worm(app.paths.getStartPoints().get(app.random.nextInt(app.paths.getStartPoints().size())), app, monsterObject));
                    }
                    MONSTER_INDEX++;
                }
                App.CURRENT_TIME = System.currentTimeMillis();
            }
            if (MONSTERS_INDEX >= app.waves[App.WAVE_INDEX].getMonsters().size()) {
                if (app.showWave.getDuration() <= 0) {
                    App.WAVE_INDEX++;
                    if (App.WAVE_INDEX < app.waves.length) {
                        MONSTERS_INDEX = 0;
                        MONSTER_INDEX = 0;
                        monsterObject = app.waves[App.WAVE_INDEX].getMonsters().getJSONObject(MONSTERS_INDEX);
                        app.showWave.setWave(App.WAVE_INDEX);
                        if (App.WAVE_INDEX < app.waves.length - 1) {
                            app.showWave.setDuration((int)app.waves[App.WAVE_INDEX].getDuration() + (int)app.waves[App.WAVE_INDEX + 1].getPreWavePause());
                        }
                        updateTimeInterval(app, App.WAVE_INDEX);
                    }
                }
            }
            else if (MONSTER_INDEX >= app.waves[App.WAVE_INDEX].getMonsters().getJSONObject(MONSTERS_INDEX).getDouble("quantity")) {
                MONSTERS_INDEX++;
                if (MONSTERS_INDEX < app.waves[App.WAVE_INDEX].getMonsters().size()) {
                    MONSTER_INDEX = 0;
                    monsterObject = app.waves[App.WAVE_INDEX].getMonsters().getJSONObject(MONSTERS_INDEX);
                }
            }
        }
    }

    @Override
    public void drawElement(App app) {
        for (Monster monster : list) {
            monster.setImage(app);
            monster.draw(app);
        }
        for (Monster monster : list) {
            if (!monster.isDie()) {
                monster.displayRect(app);
            }
        }
    }
}
