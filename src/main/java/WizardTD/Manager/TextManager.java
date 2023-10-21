package WizardTD.Manager;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The type text manager manage the text in the map.
 */
public class TextManager {
    private Stack<Text> textList;

    /**
     * Constructor: instantiates a new Text manager.
     */
    public TextManager() {
        this.textList = new Stack<>();
    }

    /**
     * Gets text stack list.
     *
     * @return the text stack list
     */
    public Stack<Text> getTextList() {
        return textList;
    }

    /**
     * Add new text to the stack.
     *
     * @param text the text
     */
    public void addNewText(Text text) {
        textList.push(text);
    }

    /**
     * Pop text from the stack.
     *
     * @return the text
     */
    public Text popText() {
        return textList.pop();
    }
}
