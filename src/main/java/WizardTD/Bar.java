package WizardTD;

public class Bar {
    private int color;
    private int height;
    private int width;
    private int HEIGHT;
    private int WIDTH;
    private int topOffset;
    private int sideOffset;

    public Bar(int color, int height, int width, int HEIGHT, int WIDTH, int topOffset, int sideOffset) {
        this.color = color;
        this.height = height;
        this.width = width;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        this.topOffset = topOffset;
        this.sideOffset = sideOffset;
    }

    public void fillPixels(int[] pixels) {
        for (int i = topOffset; i < HEIGHT && i < topOffset + height; i++) {
            for (int j = 0; j < width && j + sideOffset < WIDTH; j++) {
                pixels[i * WIDTH + sideOffset + j] = color;
            }
        }
    }
}
