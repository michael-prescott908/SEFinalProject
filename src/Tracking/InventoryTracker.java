package Tracking;

import ControllerGUI.*;
import javax.swing.*;

public class InventoryTracker {
    private static String STATE = "Basic";
    public static void main(String args[]){
        System.out.println(STATE);
        RunGUI rgui = new RunGUI(STATE);
    }

    public static void setState(String option){
        STATE = option;
    }

    public static String getState(){
        return STATE;
    }
}
