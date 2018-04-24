package ControllerGUI;

import Tracking.InventoryTracker;

import java.awt.event.ActionEvent;

public class Controller implements java.awt.event.ActionListener {

    private Model model;
    private View view;
    private String state = "Basic";
    private int localValue = 1;

    /*public Controller() {
        System.out.println ("Controller()");
    }
*/
    public void actionPerformed(ActionEvent e){

        System.out.println ("Controller: Event " + e.getActionCommand());

        if("Add Item".equals(e.getActionCommand())) {
            System.out.println("I would like to add an item");
            RunGUI rgui = new RunGUI(e.getActionCommand());
        }
        else if("Item Lookup".equals(e.getActionCommand())) {
            System.out.println("I would like to lookup and item");
            RunGUI rgui = new RunGUI(e.getActionCommand());
        }
        else if("Exit".equals(e.getActionCommand())) {
            System.exit(1);
        }
    }

    public void addModel(Model m){
        //System.out.println("Controller: adding model");
        this.model = m;
    }

    public void addView(View v){
        //System.out.println("Controller: adding view");
        this.view = v;
    }

    public void addView(MainView v){
        this.view = v;
    }

    public void addView(LookupView v){
        this.view = v;
    }

    public void initModel(int x){
        model.setValue(x);
    }

}
