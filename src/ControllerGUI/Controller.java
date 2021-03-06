package ControllerGUI;

import Table.Database;
import Tracking.InventoryTracker;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import javax.swing.*;
import javax.xml.crypto.Data;

public class Controller implements java.awt.event.ActionListener {

    private Model model;
    private View view;

    public Controller() {}

    public void actionPerformed(ActionEvent e){

        if("Add Item".equals(e.getActionCommand())) {
            InventoryTracker.setRgui(e.getActionCommand());
        }
        else if("Item Lookup".equals(e.getActionCommand())) {
            InventoryTracker.setRgui(e.getActionCommand());
        }
        else if("Exit".equals(e.getActionCommand())) {
            System.exit(1);
        }
        else if("Cancel".equals(e.getActionCommand())){
            view.getFrame().dispose();
        }
        else if("Delete Item".equals(e.getActionCommand())){
            InventoryTracker.setRgui(e.getActionCommand());
        }
        else if("Insert".equals(e.getActionCommand())){
            String text [] = {
                    view.getAddPrice().getText(),
                    view.getAddName().getText(),
                    view.getAddSerial().getText()
            };

            Connection conn = Database.connect();
            Database.insert(text, conn);

            view.getAddPrice().setText("");
            view.getAddName().setText("");
            view.getAddSerial().setText("");
        }
        else if("Remove".equals(e.getActionCommand())){
            String temp = view.getRemSerial().getText();
            Connection conn = Database.connect();
            Database.remove(Integer.parseInt(temp), conn);
            view.getRemSerial().setText("");
        }
    }

    public void addModel(Model m){
        this.model = m;
    }

    public void addView(View v){
        this.view = v;
    }

    public void addView(MainView v){
        this.view = v;
    }

    public void addView(LookupView v){
        this.view = v;
    }
}
