package ControllerGUI;

public class Model extends java.util.Observable {

    public Model() {}

    private void doNotify() {
        setChanged();
        notifyObservers();
    }
}
