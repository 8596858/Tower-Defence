package WizardTD;

/**
 * The interface Display.
 */
public interface Display {
    /**
     * Display rect.
     *
     * @param app the main app
     */
    public void displayRect(App app);

    /**
     * Display text.
     *
     * @param app   the main app
     * @param color the color
     */
    public void displayText(App app, int color);
}
