package WizardTD;

import WizardTD.Button.*;
import WizardTD.Manager.FireBallManager;
import WizardTD.Manager.MonsterManager;
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
 * The type App.
 */
public class App extends PApplet {

    /**
     * The constant CELLSIZE.
     */
    public static final int CELLSIZE = 32;
    /**
     * The constant SIDEBAR.
     */
    public static final int SIDEBAR = 120;
    /**
     * The constant TOPBAR.
     */
    public static final int TOPBAR = 40;
    /**
     * The constant BOARD_WIDTH.
     */
    public static final int BOARD_WIDTH = 20;

    /**
     * The constant WIDTH.
     */
    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    /**
     * The constant HEIGHT.
     */
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE+TOPBAR;

    /**
     * The constant FPS.
     */
    public static final int FPS = 60;

    /**
     * The constant BAR_COLOR.
     */
    public static int BAR_COLOR = -6724096;

    /**
     * The constant WORD_COLOR.
     */
    public static int WORD_COLOR = -16777216;

    /**
     * The constant BUTTON_COLOR.
     */
    public static int BUTTON_COLOR = -256;

    /**
     * The constant PROCESS_COLOR.
     */
    public static int PROCESS_COLOR = -13382401;

    /**
     * The constant WAVE_INDEX.
     */
    public static int WAVE_INDEX = -1;

    /**
     * The constant CURRENT_TIME.
     */
    public static long CURRENT_TIME = 0;
    /**
     * The constant PAUSE.
     */
    public static boolean PAUSE;
    /**
     * The constant IN_MENU.
     */
    public static boolean IN_MENU;

    /**
     * The constant IS_ACCELERATE.
     */
    public static boolean IS_ACCELERATE;

    /**
     * The constant CAN_BUILD_TOWER.
     */
    public static boolean CAN_BUILD_TOWER;

    /**
     * The Current mana.
     */
    public double currentMana;

    /**
     * The Config path.
     */
    public String configPath;

    /**
     * The Random.
     */
    public Random random = new Random();

    /**
     * The Map.
     */
    public static char[][] map;
    /**
     * The Json info.
     */
    public JsonInfo jsonInfo;
    /**
     * The Waves.
     */
    public Wave[] waves;
    /**
     * The Monster manager.
     */
    public MonsterManager monsterManager;
    /**
     * The Fire ball manager.
     */
    public FireBallManager fireBallManager;
    /**
     * The Towers.
     */
    public ArrayList<Tower> towers;
    /**
     * The Button list.
     */
    public ButtonList buttonList;
    /**
     * The Patterns.
     */
    public Pattern[][] patterns;
    /**
     * The Paths.
     */
    public Paths paths;
    /**
     * The Wizard house.
     */
    public WizardHouse wizardHouse;
    /**
     * The Is update tower.
     */
    public boolean[] isUpdateTower;
    /**
     * The Can update tower.
     */
    public boolean canUpdateTower;
    /**
     * The Tower level.
     */
    public int[] towerLevel;
    /**
     * The Mana bar.
     */
    public ManaBar manaBar;
    /**
     * The Show wave.
     */
    public ShowWave showWave;

    private boolean addTower;

    // Feel free to add any additional methods or attributes you want. Please put classes in different files.

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
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
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
        towers = new ArrayList<>();
        map = mapInfo(jsonInfo);
        currentMana = jsonInfo.getInitial_mana();
        paths = new Paths();
        buildMap(map);
        paths.findPaths(this);
//        monsterManager.updateTimeInterval(this, 0);
        manaBar = new ManaBar(WIDTH - 250, 5, 30, "MANA", this);
//        if (waves.length > 1) {
//            showWave = new ShowWave(15, 25, WAVE_INDEX, (int)(waves[WAVE_INDEX].getDuration() + waves[WAVE_INDEX + 1].getPreWavePause()));
//        }
//        else {
//            showWave = new ShowWave(15, 25, WAVE_INDEX, 0);
//        }
        showWave = new ShowWave(15, 25, WAVE_INDEX, waves[WAVE_INDEX + 1].getPreWavePause());
        buttonList = new ButtonList(jsonInfo);
    }

    private char[][] mapInfo(JsonInfo jsonInfo) {
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
                    }
                    else {
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

//    private void BuildBar() {
//        loadPixels();
//        Bar topBar = new Bar(BAR_COLOR, TOPBAR, WIDTH, HEIGHT, WIDTH, 0, 0);
//        Bar sideBar = new Bar(BAR_COLOR, HEIGHT - TOPBAR, SIDEBAR, HEIGHT, WIDTH, TOPBAR, CELLSIZE*BOARD_WIDTH);
////        System.out.println(color(51, 204, 255));
//        topBar.fillPixels(this.pixels);
//        sideBar.fillPixels(this.pixels);
//        updatePixels();
//    }

    private void buildMap(char[][] map) {
//        for (int i = 0; i < TOPBAR; i++) {
//            for (int j = 0; j < WIDTH; j++) {
//                this.pixels[i * WIDTH + j] = bufferedImage.getRGB(0, 0);
//            }
//        }
//        for (int i = TOPBAR; i < HEIGHT; i++) {
//            for (int j = 0; j < SIDEBAR; j++) {
//                this.pixels[i * WIDTH + CELLSIZE*BOARD_WIDTH + j] = bufferedImage.getRGB(0, 0);
//            }
//        }
        patterns = new Pattern[20][20];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (map[i][j] == ' ') {
                    patterns[i][j] = new Grass(i, j, this);
                }
                else if (map[i][j] == 'S') {
                    patterns[i][j] = new Shrub(i, j, this);
                }
                else if (map[i][j] == 'X') {
                    patterns[i][j] = new Path(i, j, this);
                    if (i == 0 || i == 19 || j == 0 || j == 19) {
//                        if (i == 0) {
//                            ((Path)patterns[i][j]).setDirection(0);
//                        }
//                        else if (i == 19) {
//                            ((Path)patterns[i][j]).setDirection(1);
//                        }
//                        else if (j == 0) {
//                            ((Path)patterns[i][j]).setDirection(2);
//                        }
//                        else {
//                            ((Path)patterns[i][j]).setDirection(3);
//                        }
                        paths.setStartPoints((Path)patterns[i][j]);
                    }
//                    else if ((map[i - 1][j] != 'X' && map[i][j - 1] != 'X'&& map[i + 1][j] != 'X'&& map[i][j + 1] == 'X') ||
//                            (map[i - 1][j] != 'X' && map[i][j - 1] != 'X'&& map[i + 1][j] == 'X'&& map[i][j + 1] != 'X') ||
//                            (map[i - 1][j] != 'X' && map[i][j - 1] == 'X'&& map[i + 1][j] != 'X'&& map[i][j + 1] != 'X') ||
//                            (map[i - 1][j] == 'X' && map[i][j - 1] != 'X'&& map[i + 1][j] != 'X'&& map[i][j + 1] != 'X')) {
//                        paths.setStartPoints((Path)patterns[i][j]);
//                    }
//                    bufferedImage = (BufferedImage) pImage.getNative();
//                    for (int k = 0; k < CELLSIZE; k++) {
//                        for (int l = 0; l < CELLSIZE; l++) {
//                            if (bufferedImage.getRGB(k, l) != 0) {
//                                this.pixels[(TOPBAR + i * CELLSIZE) * this.width + l * this.width + (j * CELLSIZE) + k] = bufferedImage.getRGB(k, l);
//                            }
//                        }
//                    }
                }
                else if (map[i][j] == 'W') {
                    patterns[i][j] = new WizardHouse(i, j, this);
                    wizardHouse = (WizardHouse)(patterns[i][j]);
                }
            }
        }
//        bufferedImage = (BufferedImage) pImage.getNative();
//        for (int l = 0; l < pImage.width; l++) {
//            for (int k = 0; k < pImage.height; k++) {
//                if (bufferedImage.getRGB(k, l) != 0 && bufferedImage.getRGB(k, l) != -16777216) {
//                    this.pixels[(TOPBAR + houseX * CELLSIZE + (CELLSIZE - pImage.height) / 2) * WIDTH
//                            + l * WIDTH + (houseY * CELLSIZE + (CELLSIZE - pImage.width) / 2) + k] = bufferedImage.getRGB(k, l);
//                }
//            }
//        }
    }

    private void drawMap() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                patterns[i][j].fillPixels(this);
//                if (patterns[i][j].getType().substring(0, 5).matches("tower")) {
//                    System.out.println(((Tower)patterns[i][j]).getLevel()[0]);
//                }
            }
        }
    }

    /**
     * Receive key pressed signal from the keyboard.
     */
    @Override
    public void keyPressed(KeyEvent key){
        if (key.getKey() == 'p') {
            buttonList.getButtons()[1].clickButton(this);
        }
        if (!PAUSE) {
            if (key.getKey() == 'f') {
                buttonList.getButtons()[0].clickButton(this);
            }
            if (key.getKey() == 't') {
                buttonList.getButtons()[2].clickButton(this);
            }
            if (key.getKey() == '1') {
                buttonList.getButtons()[3].clickButton(this);
            }
            if (key.getKey() == '2') {
                buttonList.getButtons()[4].clickButton(this);
            }
            if (key.getKey() == '3') {
                buttonList.getButtons()[5].clickButton(this);
            }
            if (key.getKey() == 'm') {
                buttonList.getButtons()[6].clickButton(this);
            }
        }
        if (key.getKey() == 'r') {
            if (manaBar.getProcess() <= 0) {
                setup();
                FireBall.SPEED = 5f;
            }
            else if (WAVE_INDEX == waves.length && monsterManager.getMonsters().size() == 0) {
                IN_MENU = true;
            }
        }
    }

    /**
     * Receive key released signal from the keyboard.
     */
    @Override
    public void keyReleased(){

    }

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
            if (buttonList.getButtons()[index].getLabel().matches("P")) {
                buttonList.getButtons()[1].clickButton(this);
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
                }
            }
        }
        else if (mouseInMap()) {
            int[] coordinate = patternCoordinate(e.getY(), e.getX());
            if (!PAUSE) {
                if (CAN_BUILD_TOWER && patterns[coordinate[0]][coordinate[1]].getType().matches("grass.png")) {
                    patterns[coordinate[0]][coordinate[1]] = new Tower(coordinate[0], coordinate[1], this);
                    towers.add((Tower)patterns[coordinate[0]][coordinate[1]]);
                    patterns[coordinate[0]][coordinate[1]].fillPixels(this);
                    this.addTower = true;
//                    CAN_BUILD_TOWER = false;
//                    buttonList.getButtons()[2].setUsing(false);
                }
                else if (patterns[coordinate[0]][coordinate[1]].getType().substring(0, 5).matches("tower") && canUpdateTower) {
                    ((Tower)patterns[coordinate[0]][coordinate[1]]).updateLevel(isUpdateTower, this);
                    canUpdateTower = false;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int index = mouseInButton(buttonList.getButtons());
        if (index != -1) {
            if (buttonList.getButtons()[index].getLabel().matches("M")) {
                buttonList.getButtons()[index].setUsing(false);
            }
        }
        else if (mouseInMap()) {
            int[] coordinate = patternCoordinate(e.getY(), e.getX());
            if (!PAUSE) {
                if (CAN_BUILD_TOWER && patterns[coordinate[0]][coordinate[1]].getType().matches("grass.png")) {
                    patterns[coordinate[0]][coordinate[1]] = new Tower(coordinate[0], coordinate[1], this);
                    towers.add((Tower)patterns[coordinate[0]][coordinate[1]]);
                    patterns[coordinate[0]][coordinate[1]].fillPixels(this);
                    this.addTower = true;
//                    CAN_BUILD_TOWER = false;
//                    buttonList.getButtons()[2].setUsing(false);
                }
                canUpdateTower = true;
            }
        }
    }

    /*@Override
    public void mouseDragged(MouseEvent e) {

    }*/

    /**
     * Draw all elements in the game by current frame.
     */
    @Override
    public void draw() {
        if (IN_MENU) {
            background(BAR_COLOR);
            for (int i = 0; i < 4; i++) {
                buttonList.getButtons()[i + 7].displayButton(this, color(0, 0, 0));
            }
        }
        else {
            if (!PAUSE) {
//                background(BAR_COLOR);
                if (WAVE_INDEX < jsonInfo.getWaves().size()) {
                    monsterManager.generate(this);
                }
                fireBallManager.generate(this);
                drawMap();
                monsterManager.update(this);
                if (manaBar.getProcess() <= Tower.TOWER_COST) {
                    buttonList.getButtons()[2].setUsing(false);
                    CAN_BUILD_TOWER = false;
                }
                fireBallManager.update(this);
                drawBar();
                if (mouseInMap()) {
                    displayTowerRange(mouseY, mouseX);
                }
                if (mouseInButton(buttonList.getButtons()) == 6) {
                    ((ManaPool)buttonList.getButtons()[6]).display(this);
                }
                if (WAVE_INDEX < waves.length - 1) {
                    showWave.displayText(this, WORD_COLOR);
                }
                manaBar.updateProcess(addTower);
                this.addTower = false;
                manaBar.display(this, WORD_COLOR);
                wizardHouse.fillPixels(this);
            }
            if (manaBar.getProcess() <= 0) {
                fill(color(0, 255, 0));
                textSize(CELLSIZE);
                text("YOU LOST", (float) ((BOARD_WIDTH - 8) * CELLSIZE) / 2, 5 * CELLSIZE + TOPBAR);
                textSize((float) CELLSIZE / 2);
                text("Press 'r' to restart", (float) ((BOARD_WIDTH - 8) * CELLSIZE) / 2 - 15, 5 * CELLSIZE + TOPBAR + 60);
                PAUSE = true;
            }
            if (WAVE_INDEX == waves.length && monsterManager.getMonsters().size() == 0) {
                fill(color(255, 0, 230));
                textSize(CELLSIZE);
                text("YOU WIN", (float) ((BOARD_WIDTH - 7) * CELLSIZE) / 2, 5 * CELLSIZE + TOPBAR);
                PAUSE = true;
            }
            for (int i = 0; i < 7; i++) {
                buttonList.getButtons()[i].displayButton(this, color(0, 0, 0));
            }
        }
    }

    private void drawBar() {
        loadPixels();
        for (int i = 0; i < HEIGHT; i++) {
            if (i < TOPBAR) {
                for (int j = 0; j < WIDTH; j++) {
                    pixels[i * WIDTH + j] = BAR_COLOR;
                }
            }
            else {
                for (int j = BOARD_WIDTH * CELLSIZE; j < WIDTH; j++) {
                    pixels[i * WIDTH + j] = BAR_COLOR;
                }
            }
        }
        updatePixels();
    }

    private void displayTowerRange(int x, int y) {
        int[] coordinate = patternCoordinate(x, y);
        if (patterns[coordinate[0]][coordinate[1]].getType().substring(0, 5).matches("tower")) {
            ((Tower)patterns[coordinate[0]][coordinate[1]]).display(this);
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
     * Mouse in map boolean.
     *
     * @return the boolean
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
     * Pattern coordinate int [ ].
     *
     * @param x the x position of pattern
     * @param y the y position of pattern
     * @return the coordinate
     */
    public int[] patternCoordinate(int x, int y) {
        int[] result = new int[2];
        result[0] = (x - TOPBAR) / CELLSIZE;
        result[1] = y / CELLSIZE;
        return result;
    }

    /**
     * Source: https://stackoverflow.com/questions/37758061/rotate-a-buffered-image-in-java
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
        //BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
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
