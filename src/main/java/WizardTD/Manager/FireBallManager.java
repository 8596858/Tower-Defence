package WizardTD.Manager;

import WizardTD.App;
import WizardTD.FireBall;
import WizardTD.Pattern.Tower;

/**
 * This class is used to manage the fireballs.
 */
public class FireBallManager extends Manager<FireBall>{

    /**
     * Constructor: instantiates a new fireball manager.
     */
    public FireBallManager() {
        super();
    }

    /**
     * This method identify if the fireballs have to move or finish.
     */
    @Override
    public void update(App app) {
        for (int i = 0; i < list.size();) {
            if (list.get(i).isFinish()) {
                list.remove(i);
            }
            else {
                list.get(i).move(app);
                i++;
            }
        }
    }

    /**
     * This method is used to generate the fireballs base on the info provided by towers.
     */
    @Override
    public void generate(App app) {
        for (Tower tower : app.towers) {
            int index = 0;
            double test = Double.POSITIVE_INFINITY;
            for (int i = 0; i < app.monsterManager.getMonsters().size(); i++) {
                if (!app.monsterManager.getMonsters().get(i).isDie()) {
                    double distance = Math.sqrt((app.monsterManager.getMonsters().get(i).getX() - tower.getX() * App.CELLSIZE - App.TOPBAR) * (app.monsterManager.getMonsters().get(i).getX() - tower.getX() * App.CELLSIZE - App.TOPBAR)
                            + (app.monsterManager.getMonsters().get(i).getY() - tower.getY() * App.CELLSIZE) * (app.monsterManager.getMonsters().get(i).getY() - tower.getY() * App.CELLSIZE));
                    if (distance < test) {
                        test = distance;
                        index = i;
                    }
                }
            }
            if (test <= tower.getRange() && System.currentTimeMillis() - tower.getTimer() >= 1000 / tower.getFiringSpeed()) {
                list.add(new FireBall(tower.getX(), tower.getY(), tower.getDamage(), app.monsterManager.getMonsters().get(index)));
                tower.setTimer(System.currentTimeMillis());
            }
        }
    }

    /**
     * Draw the fireballs in the map.
     */
    @Override
    public void drawElement(App app, ShapeManager shapeManager) {
        for (FireBall fireBall : list) {
            fireBall.draw(app);
        }
    }
}
