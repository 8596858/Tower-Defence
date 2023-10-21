package WizardTD;

import WizardTD.Manager.ShapeManager;
import WizardTD.Manager.TextManager;

/**
 * The interface Display.
 */
public interface Display {
    /**
     * Add shapes to the shape manager.
     *
     * @param shapeManager the shape manager
     */
    public void addShape(App app, ShapeManager shapeManager);

    /**
     * Add texts to the text manager.
     *
     * @param textManager the text manager
     */
    public void addText(App app, TextManager textManager);
}
