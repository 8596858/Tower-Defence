package WizardTD;

import WizardTD.Button.*;
import WizardTD.Manager.*;
import WizardTD.Pattern.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.*;

/**
 * The main App.
 * This is the class to run the game.
 */
public class App extends PApplet {

    /**
     * The constant CELLSIZE defines the size of a cell in the map.
     */
    public static final int CELLSIZE = 32;
    /**
     * The constant SIDEBAR is the width of the bar on the right.
     */
    public static final int SIDEBAR = 120;
    /**
     * The constant TOPBAR is the height of the bar on the top.
     */
    public static final int TOPBAR = 40;
    /**
     * The constant BOARD_WIDTH is the number of the cell in column and row of the map.
     */
    public static final int BOARD_WIDTH = 20;

    /**
     * The constant WIDTH is the width of the panel.
     */
    public static int WIDTH = CELLSIZE * BOARD_WIDTH + SIDEBAR;
    /**
     * The constant HEIGHT is the height of the panel.
     */
    public static int HEIGHT = BOARD_WIDTH * CELLSIZE + TOPBAR;

    /**
     * The constant FPS: frame per second.
     */
    public static final int FPS = 60;

    /**
     * The constant BAR_COLOR is the color of the bar.
     */
    public static int BAR_COLOR = 0xb88d00;

    /**
     * The constant WORD_COLOR is the color of the text.
     */
    public static int WORD_COLOR = 0x000000;

    /**
     * The constant BUTTON_COLOR is the color of the button when you click it.
     */
    public static int BUTTON_COLOR = 0xf5e105;

    /**
     * The constant PROCESS_COLOR is the color of the mana bar's process.
     */
    public static int PROCESS_COLOR = 0x03cffc;

    /**
     * The constant WHITE_COLOR is the white color for information field.
     */
    public static int WHITE_COLOR = 0xffffff;

    /**
     * The constant RED_COLOR is the red color for monster's lost hp.
     */
    public static int RED_COLOR = 0xfc0303;

    /**
     * The constant HP_COLOR is the color for the monster's remaining hp.
     */
    public static int HP_COLOR = 0x03fc39;

    /**
     * The constant LEVEL_COLOR1 is the color to show the tower level.
     */
    public static int LEVEL_COLOR1 = 0xfc03e3;

    /**
     * The constant LEVEL2_COLOR is the color to show the tower level..
     */
    public static int LEVEL_COLOR2 = 0x03b1fc;

    /**
     * The constant WAVE_INDEX represent the current wave index.
     */
    public static int WAVE_INDEX = -1;

    /**
     * The constant CURRENT_TIME used to calculate the time going.
     */
    public static long CURRENT_TIME = 0;
    /**
     * The constant PAUSE indicates whether the game is paused.
     */
    public static boolean PAUSE;
    /**
     * The constant IN_MENU indicates whether the game is in menu state.
     */
    public static boolean IN_MENU;

    /**
     * The constant IS_ACCELERATE indicates whether the game is accelerated.
     */
    public static boolean IS_ACCELERATE;

    /**
     * The constant CAN_BUILD_TOWER indicates whether the player can build a tower.
     */
    public static boolean CAN_BUILD_TOWER;

    /**
     * The Config path represent the json file we are using.
     */
    public String configPath;

    /**
     * The Random is used to generate random number.
     */
    public Random random = new Random();

    /**
     * The Map store the information of the map.
     */
    public static char[][] map;
    /**
     * The JsonInfo store the information the game.
     */
    public JsonInfo jsonInfo;
    /**
     * The Waves store the info of a wave, include monster, duration, and so on.
     */
    public Wave[] waves;
    /**
     * The MonsterManager is used to manage the monster's generate and update.
     */
    public MonsterManager monsterManager;
    /**
     * The FireBallManager is used to manage the fireball's generate and update.
     */
    public FireBallManager fireBallManager;
    /**
     * The ShapeManager is used to store the shapes that will display in the map.
     */
    public ShapeManager shapeManager;
    /**
     * The TextManager is used to store the texts that will display in the map.
     */
    public TextManager textManager;
    /**
     * The Towers stores the tower that built by player.
     */
    public ArrayList<Tower> towers;
    /**
     * The ButtonList stores the buttons in the game.
     */
    public ButtonList buttonList;
    /**
     * The Patterns stores the patterns will display in the map.
     */
    public Pattern[][] patterns;
    /**
     * The Paths manage the paths in the map.
     */
    public Paths paths;
    /**
     * The WizardHouse is the end point of the monster.
     */
    public WizardHouse wizardHouse;
    /**
     * The isUpdateTower show the player the properties of tower will be updated.
     */
    public boolean[] isUpdateTower;
    /**
     * The Can update tower tell the player if they can update the tower.
     */
    public boolean canUpdateTower;
    /**
     * The TowerLevel shows the properties level of the tower that will be built.
     */
    public int[] towerLevel;
    /**
     * The ManaBar manage the properties of the mana bar.
     */
    public ManaBar manaBar;
    /**
     * The ShowWave can update the wave info in the up left corner.
     */
    public ShowWave showWave;

    private boolean addTower;

    // Feel free to add any additional methods or attributes you want. Please put
    // classes in different files.

    /**
     * Instantiates a new App.
     */
    public App() {
        IN_MENU = true;
        this.configPath = "config.json";
    }

    /**
     * Initialise the setting of the window size.
     */
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the
     * player, enemies and map elements.
     */
    @Override
    public void setup() {
        frameRate(FPS);

        // Load images during setup
        // Eg:

        CURRENT_TIME = 0;
        WAVE_INDEX = -1;
        IS_ACCELERATE = false;
        PAUSE = false;
        CURRENT_TIME = System.currentTimeMillis();
        CAN_BUILD_TOWER = false;
        towerLevel = new int[3];
        isUpdateTower = new boolean[3];
        canUpdateTower = false;
        jsonInfo = new JsonInfo(this.configPath);
        Tower.TOWER_COST = jsonInfo.getTower_cost();
        waves = new Wave[jsonInfo.getWaves().size()];
        for (int i = 0; i < jsonInfo.getWaves().size(); i++) {
            waves[i] = new Wave(jsonInfo.getWaves().getJSONObject(i));
        }
        monsterManager = new MonsterManager(this);
        fireBallManager = new FireBallManager();
        shapeManager = new ShapeManager();
        textManager = new TextManager();
        towers = new ArrayList<>();
        map = mapInfo(jsonInfo);
        paths = new Paths();
        buildMap(map, paths);
        paths.findPaths(this);
        // monsterManager.updateTimeInterval(this, 0);
        manaBar = new ManaBar(WIDTH - 250, 5, 30, "MANA", this);
        showWave = new ShowWave(15, 25, WAVE_INDEX, waves[WAVE_INDEX + 1].getPreWavePause());
        buttonList = new ButtonList(jsonInfo);
    }

    /**
     * Store the map info into char array.
     *
     * @param jsonInfo json file information.
     * @return the char array.
     */
    public char[][] mapInfo(JsonInfo jsonInfo) {
        File file = new File(jsonInfo.getLayout());
        char[][] map = new char[20][20];
        try {
            Scanner in = new Scanner(file);
            String line = "";
            for (int i = 0; i < 20; i++) {
                line = in.nextLine();
                for (int j = 0; j < 20; j++) {
                    if (j < line.length()) {
                        map[i][j] = line.charAt(j);
                    } else {
                        map[i][j] = ' ';
                    }
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    /**
     * Build map of the game base on the level txt file.
     *
     * @param map   the map store the map info
     * @param paths the paths will store thr start points of the monster
     */
    public void buildMap(char[][] map, Paths paths) {
        patterns = new Pattern[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (map[i][j] == ' ') {
                    patterns[i][j] = new Grass(i, j);
                } else if (map[i][j] == 'S') {
                    patterns[i][j] = new Shrub(i, j);
                } else if (map[i][j] == 'X') {
                    patterns[i][j] = new Path(i, j);
                    if (i == 0 || i == 19 || j == 0 || j == 19) {
                        paths.setStartPoints((Path) patterns[i][j]);
                    }
                } else if (map[i][j] == 'W') {
                    patterns[i][j] = new WizardHouse(i, j);
                    wizardHouse = (WizardHouse) (patterns[i][j]);
                }
            }
        }
    }

    private void drawMap() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (patterns[i][j].getImage() == null) {
                    patterns[i][j].setImage(this);
                }
                if (!patterns[i][j].getType().matches("wizard_house.png")) {
                    image(patterns[i][j].getImage(),
                            patterns[i][j].getY() * CELLSIZE,
                            patterns[i][j].getX() * CELLSIZE + TOPBAR);
                }
            }
        }
    }

    /**
     * Receive key pressed signal from the keyboard.
     */
    @Override
    public void keyPressed(KeyEvent key) {
        if (key.getKey() == 'r') {
            if (manaBar.getProcess() <= 0) {
                setup();
                FireBall.SPEED = 5f;
            } else if (WAVE_INDEX == waves.length && monsterManager.getMonsters().size() == 0) {
                IN_MENU = true;
            }
        }
    }

    /**
     * Receive key released signal from the keyboard.
     */
    @Override
    public void keyReleased() {
        if (manaBar.getProcess() >= 0 && (WAVE_INDEX < waves.length || monsterManager.getMonsters().size() > 0)) {
            if (this.key == 'p') {
                buttonList.getButtons()[1].clickButton(this);
            }
        }
        if (!PAUSE) {
            if (this.key == 'f') {
                buttonList.getButtons()[0].clickButton(this);
            }
            if (this.key == 't') {
                buttonList.getButtons()[2].clickButton(this);
            }
            if (this.key == '1') {
                buttonList.getButtons()[3].clickButton(this);
            }
            if (this.key == '2') {
                buttonList.getButtons()[4].clickButton(this);
            }
            if (this.key == '3') {
                buttonList.getButtons()[5].clickButton(this);
            }
            if (this.key == 'm') {
                buttonList.getButtons()[6].clickButton(this);
                buttonList.getButtons()[6].setUsing(false);
            }
        }
    }

    /**
     * Receive mouse pressed signal from the mouse, and activate some event.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int index = mouseInButton(buttonList.getButtons());
        if (index != -1) {
            if (IN_MENU) {
                if (buttonList.getButtons()[index].getLabel().matches("1")) {
                    buttonList.getButtons()[7].clickButton(this);
                    setup();
                    IN_MENU = false;
                }
                if (buttonList.getButtons()[index].getLabel().matches("2")) {
                    buttonList.getButtons()[8].clickButton(this);
                    setup();
                    IN_MENU = false;
                }
                if (buttonList.getButtons()[index].getLabel().matches("3")) {
                    buttonList.getButtons()[9].clickButton(this);
                    setup();
                    IN_MENU = false;
                }
                if (buttonList.getButtons()[index].getLabel().matches("4")) {
                    buttonList.getButtons()[10].clickButton(this);
                    setup();
                    IN_MENU = false;
                }
            }
            if (manaBar.getProcess() >= 0 && (WAVE_INDEX < waves.length || monsterManager.getMonsters().size() > 0)) {
                if (buttonList.getButtons()[index].getLabel().matches("P")) {
                    buttonList.getButtons()[1].clickButton(this);
                }
            }
            if (!PAUSE) {
                if (buttonList.getButtons()[index].getLabel().matches("T")) {
                    buttonList.getButtons()[2].clickButton(this);
                }
                if (buttonList.getButtons()[index].getLabel().matches("FF")) {
                    buttonList.getButtons()[0].clickButton(this);
                }
                if (buttonList.getButtons()[index].getLabel().matches("U1")) {
                    buttonList.getButtons()[3].clickButton(this);
                }
                if (buttonList.getButtons()[index].getLabel().matches("U2")) {
                    buttonList.getButtons()[4].clickButton(this);
                }
                if (buttonList.getButtons()[index].getLabel().matches("U3")) {
                    buttonList.getButtons()[5].clickButton(this);
                }
                if (buttonList.getButtons()[index].getLabel().matches("M")) {
                    buttonList.getButtons()[6].clickButton(this);
                    buttonList.getButtons()[6].setUsing(false);
                }
            }
        } else if (mouseInMap()) {
            int[] coordinate = patternCoordinate(e.getY(), e.getX());
            if (!PAUSE) {
                if (CAN_BUILD_TOWER && patterns[coordinate[0]][coordinate[1]].getType().matches("grass.png")) {
                    patterns[coordinate[0]][coordinate[1]] = new Tower(coordinate[0], coordinate[1], this);
                    towers.add((Tower) patterns[coordinate[0]][coordinate[1]]);
                    patterns[coordinate[0]][coordinate[1]].setImage(this);
                    this.addTower = true;
                    CAN_BUILD_TOWER = false;
                    buttonList.getButtons()[2].setUsing(false);
                } else if (patterns[coordinate[0]][coordinate[1]].getType().substring(0, 5).matches("tower")
                        && canUpdateTower) {
                    ((Tower) patterns[coordinate[0]][coordinate[1]]).updateLevel(isUpdateTower, this);
                    patterns[coordinate[0]][coordinate[1]].setImage(this);
                    canUpdateTower = false;
                }
            }
        }
    }

    /**
     * Receive mouse released signal from the mouse, and activate some event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (mouseInMap()) {
            int[] coordinate = patternCoordinate(e.getY(), e.getX());
            if (!PAUSE) {
                if (CAN_BUILD_TOWER && patterns[coordinate[0]][coordinate[1]].getType().matches("grass.png")) {
                    patterns[coordinate[0]][coordinate[1]] = new Tower(coordinate[0], coordinate[1], this);
                    towers.add((Tower) patterns[coordinate[0]][coordinate[1]]);
                    patterns[coordinate[0]][coordinate[1]].setImage(this);
                    this.addTower = true;
                    CAN_BUILD_TOWER = false;
                    buttonList.getButtons()[2].setUsing(false);
                }
                canUpdateTower = true;
            }
        }
    }

    /*
     * @Override
     * public void mouseDragged(MouseEvent e) {
     * 
     * }
     */

    /**
     * Draw all elements in the game by current frame.
     */
    @Override
    public void draw() {
        if (IN_MENU) {
            background(BAR_COLOR);
            for (int i = 0; i < 4; i++) {
                buttonList.getButtons()[i + 7].addShape(this, shapeManager);
                buttonList.getButtons()[i + 7].addText(this, textManager);
            }
            displayShapeAndText();
        } else {
            if (!PAUSE) {
                // background(BAR_COLOR);
                if (WAVE_INDEX < jsonInfo.getWaves().size()) {
                    monsterManager.generate(this);
                }
                fireBallManager.generate(this);
                drawMap();
                for (Tower tower : towers) {
                    tower.fillPixels(shapeManager);
                }
                monsterManager.update(this);
                monsterManager.drawElement(this, shapeManager);
                if (manaBar.getProcess() <= Tower.TOWER_COST) {
                    buttonList.getButtons()[2].setUsing(false);
                    CAN_BUILD_TOWER = false;
                }
                fireBallManager.update(this);
                fireBallManager.drawElement(this, shapeManager);
                displayShapeAndText();
                drawBar();
                if (mouseInMap()) {
                    displayTowerRange(mouseY, mouseX);
                }
                if (mouseInButton(buttonList.getButtons()) == 6) {
                    ((ManaPool) buttonList.getButtons()[6]).display(shapeManager, textManager);
                }
                if (mouseInButton(buttonList.getButtons()) == 2) {
                    ((PutTower) buttonList.getButtons()[2]).display(shapeManager, textManager);
                }
                if (WAVE_INDEX < waves.length - 1) {
                    showWave.addText(this, textManager);
                }
                manaBar.updateProcess(addTower);
                this.addTower = false;
                manaBar.display(this, shapeManager, textManager);
                BufferedImage bufferedImage = (BufferedImage) wizardHouse.getImage().getNative();
                loadPixels();
                for (int k = 0; k < bufferedImage.getHeight() && k + CELLSIZE * wizardHouse.getX() + (CELLSIZE - bufferedImage.getHeight()) / 2 + TOPBAR < HEIGHT; k++) {
                    for (int l = 0; l < bufferedImage.getWidth() && l + CELLSIZE * wizardHouse.getY() + (CELLSIZE - bufferedImage.getWidth()) / 2 < WIDTH - SIDEBAR; l++) {
                        if (bufferedImage.getRGB(l, k) != 0 && bufferedImage.getRGB(l, k) != -16777216) {
                            pixels[(TOPBAR + wizardHouse.getX() * CELLSIZE + (CELLSIZE - bufferedImage.getHeight()) / 2) * App.WIDTH
                                    + k * WIDTH + (wizardHouse.getY() * CELLSIZE + (CELLSIZE - bufferedImage.getWidth()) / 2) + l] = bufferedImage.getRGB(l, k);
                        }
                    }
                }
                updatePixels();
            }
            if (manaBar.getProcess() <= 0) {
                fill(color(0, 255, 0));
                textSize(CELLSIZE);
                text("YOU LOST", (float) ((BOARD_WIDTH - 8) * CELLSIZE) / 2, 5 * CELLSIZE + TOPBAR);
                textSize((float) CELLSIZE / 2);
                text("Press 'r' to restart", (float) ((BOARD_WIDTH - 8) * CELLSIZE) / 2 - 15,
                        5 * CELLSIZE + TOPBAR + 60);
                PAUSE = true;
            }
            if (WAVE_INDEX == waves.length && monsterManager.getMonsters().size() == 0) {
                fill(color(255, 0, 230));
                textSize(CELLSIZE);
                text("YOU WIN", (float) ((BOARD_WIDTH - 7) * CELLSIZE) / 2, 5 * CELLSIZE + TOPBAR);
                PAUSE = true;
            }
            for (int i = 0; i < 7; i++) {
                buttonList.getButtons()[i].addShape(this, shapeManager);
                buttonList.getButtons()[i].addText(this, textManager);
            }
            displayShapeAndText();
        }

    }

    /**
     * Display the shape and text in the panel.
     */
    private void displayShapeAndText() {
        while (!shapeManager.getShapeList().empty()) {
            Shape shape = shapeManager.popShape();
            stroke(color((shape.getStrokeColor()&0xff0000)>>16, (shape.getStrokeColor()&0x00ff00)>>8, shape.getStrokeColor()&0x0000ff));
            if (shape.getAlpha() == 0) {
                fill(shape.getFillColor(), 0);
            }
            else {
                fill(color((shape.getFillColor()&0xff0000)>>16, (shape.getFillColor()&0x00ff00)>>8, shape.getFillColor()&0x0000ff));
            }
            if (shape.getType() == 1) {
                rect(shape.getA(), shape.getB(), shape.getC(), shape.getD());
            }
            else if (shape.getType() == 2){
                ellipse(shape.getA(), shape.getB(), shape.getC(), shape.getD());
            }
        }
        while (!textManager.getTextList().empty()) {
            Text text = textManager.popText();
            fill(color((text.getColor()&0xff0000)>>16, (text.getColor()&0x00ff00)>>8, text.getColor()&0x0000ff));
            textSize(text.getSize());
            text(text.getContent(), text.getX(), text.getY());
        }
    }

    /**
     * Draw the bar in the panel.
     */
    private void drawBar() {
        stroke(color((BAR_COLOR&0xff0000)>>16, (BAR_COLOR&0x00ff00)>>8, BAR_COLOR&0x0000ff));
        fill(color((BAR_COLOR&0xff0000)>>16, (BAR_COLOR&0x00ff00)>>8, BAR_COLOR&0x0000ff));
        rect(0, 0, WIDTH, TOPBAR);
        rect(20 * CELLSIZE, TOPBAR, SIDEBAR, 20 * CELLSIZE);
    }

    /**
     * Display the tower range when you place the mouse on the tower.
     */
    private void displayTowerRange(int x, int y) {
        int[] coordinate = patternCoordinate(x, y);
        if (patterns[coordinate[0]][coordinate[1]].getType().substring(0, 5).matches("tower")) {
            ((Tower) patterns[coordinate[0]][coordinate[1]]).display(this, shapeManager, textManager);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        PApplet.main("WizardTD.App");
    }

    /**
     * Determine whether the mouse is in the map.
     *
     * @return the determine result
     */
    public boolean mouseInMap() {
        return mouseY > TOPBAR && mouseX < WIDTH - SIDEBAR;
    }

    /**
     * If the mouse in buttons, return the index of button.
     *
     * @param buttons the buttons
     * @return the index of button
     */
    public int mouseInButton(Button[] buttons) {
        if (!IN_MENU) {
            for (int i = 0; i < 7; i++) {
                if (mouseX >= buttons[i].getStartX() && mouseX <= buttons[i].getEndX() &&
                        mouseY >= buttons[i].getStartY() && mouseY <= buttons[i].getEndY()) {
                    return i;
                }
            }
        }
        if (IN_MENU) {
            for (int i = 7; i < buttons.length; i++) {
                if (mouseX >= buttons[i].getStartX() && mouseX <= buttons[i].getEndX() &&
                        mouseY >= buttons[i].getStartY() && mouseY <= buttons[i].getEndY()) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Calculate the pattern coordinate by the pixel coordinate.
     *
     * @param x the x coordinate of pixel
     * @param y the y coordinate of pixel
     * @return the coordinate of pattern
     */
    public int[] patternCoordinate(int x, int y) {
        int[] result = new int[2];
        result[0] = (x - TOPBAR) / CELLSIZE;
        result[1] = y / CELLSIZE;
        return result;
    }

    /**
     * Source:
     * https://stackoverflow.com/questions/37758061/rotate-a-buffered-image-in-java
     *
     * @param pimg  The image to be rotated
     * @param angle between 0 and 360 degrees
     * @return the new rotated image
     */
    public PImage rotateImageByDegrees(PImage pimg, double angle) {
        BufferedImage img = (BufferedImage) pimg.getNative();
        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        PImage result = this.createImage(newWidth, newHeight, RGB);
        // BufferedImage rotated = new BufferedImage(newWidth, newHeight,
        // BufferedImage.TYPE_INT_ARGB);
        BufferedImage rotated = (BufferedImage) result.getNative();
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        for (int i = 0; i < newWidth; i++) {
            for (int j = 0; j < newHeight; j++) {
                result.set(i, j, rotated.getRGB(i, j));
            }
        }

        return result;
    }
}
