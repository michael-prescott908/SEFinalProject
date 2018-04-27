package ControllerGUI;

/**
 * Class: Model
 *  Model inherits from the Observable class and serves
 *  a custom model
 */
public class Model extends java.util.Observable {

    public Model() {}

    private void doNotify() {
        setChanged();
        notifyObservers();
    }
}
