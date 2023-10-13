package WizardTD.Manager;

import WizardTD.App;

import java.util.ArrayList;

/**
 * This abstract class is used to extend other management classes
 *
 * @param <T> the type parameter
 */
public abstract class Manager <T>{
    /**
     * The list of element.
     */
    protected ArrayList<T> list;

    /**
     * Constructor: instantiates a new Manager.
     */
    public Manager() {
        list = new ArrayList<>();
    }

    /**
     * This abstract method is used to update the list
     *
     * @param app the app
     */
    public abstract void update(App app);

    /**
     * This abstract method is used to generate the node in the list
     *
     * @param app the app
     */
    public abstract void generate(App app);
}
