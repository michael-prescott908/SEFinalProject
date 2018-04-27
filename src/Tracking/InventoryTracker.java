package Tracking;

import ControllerGUI.*;
import javax.swing.*;

/**
 * Class InventoryTracker
 *  InventoryTracker serves as the main driver of the program. It
 *  is abstracted down to a single line and also acts as a singleton to
 *  set its state
 */
public class InventoryTracker {
    private static String STATE = "Basic";
    private static RunGUI rgui;

    public static void main(String args[]){
        rgui = new RunGUI(STATE);
    }

    public static void setState(String option){
        STATE = option;
    }

    public static String getState(){
        return STATE;
    }

    public static RunGUI getRgui() {
        return rgui;
    }

    public static void setRgui(String command){
        rgui = new RunGUI(command);
    }
}
