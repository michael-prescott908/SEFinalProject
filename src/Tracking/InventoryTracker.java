package Tracking;

import ControllerGUI.*;
import javax.swing.*;

public class InventoryTracker {
    private static String STATE = "Basic";
    private static RunGUI rgui;

    public static void main(String args[]){
        System.out.println(STATE);
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
