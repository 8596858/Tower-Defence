package WizardTD.Monster;

import WizardTD.App;
import WizardTD.Pattern.Path;
import processing.data.JSONObject;

import java.awt.image.BufferedImage;

/**
 * The monster type Beetle.
 */
public class Beetle extends Monster {
    private int index;

    /**
     * Constructor: instantiates a new Beetle.
     *
     * @param path       the path
     * @param app        the app
     * @param jsonObject the json object
     */
    public Beetle(Path path, App app, JSONObject jsonObject) {
        super(path, "beetle.png", app, jsonObject);
        index = 0;
    }


    @Override
    public void move(App app) {
        if (currentPath.getDirection().get(index) == 0) {
            this.type = "beetle2.png";
            if (this.x >= (currentPath.getX() + 1) * App.CELLSIZE + App.TOPBAR) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        else if (currentPath.getDirection().get(index) == 1) {
            this.type = "beetle.png";
            if (this.x <= (currentPath.getX() - 1) * App.CELLSIZE + App.TOPBAR) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        else if (currentPath.getDirection().get(index) == 2) {
            this.type = "beetle1.png";
            if (this.y >= (currentPath.getY() + 1) * App.CELLSIZE) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        else {
            this.type = "beetle3.png";
            if (this.y <= (currentPath.getY() - 1) * App.CELLSIZE) {
                if (currentPath.getParent().size() == 0) {
                    this.x = this.startX;
                    this.y = this.startY;
                    currentPath = startentPath;
                    this.index = app.random.nextInt(startentPath.getDirection().size());
                    app.manaBar.beAttacked(this);
                }
                else {
                    currentPath = (Path)currentPath.getParent().get(index);
                    this.index = app.random.nextInt(currentPath.getDirection().size());
                }
            }
        }
        if (currentPath.getDirection().get(index) == 0) {
            this.x += speed;
        }
        else if (currentPath.getDirection().get(index) == 1) {
            this.x -= speed;
        }
        else if (currentPath.getDirection().get(index) == 2) {
            this.y += speed;
        }
        else if (currentPath.getDirection().get(index) == 3) {
            this.y -= speed;
        }
    }

    @Override
    public boolean monsterDie(App app) {
        if (index < 16) {
            if (index >= 4) {
                this.type = "beetle" + (index / 4) + ".png";
            }
        }
        else {
            return true;
        }
        index++;
        return false;
    }
}
