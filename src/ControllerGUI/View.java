package ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.lang.Integer;
import java.util.Observable;
import java.awt.event.ActionListener;

public class View implements java.util.Observer {

    protected TextField inputTextField;
    protected TextField myTextField;
    protected TextField errTextField;
    protected JButton buttonAddItem;
    protected JButton buttonLookup;
    protected JButton buttonExit;
    protected Model model;
    protected JComboBox comboBox;

    protected boolean error = false;

    public View(){}

    public void update(Observable obs, Object obj) {


        if (!error) {
            // System.out.println ("View      : Observable is " + obs.getClass() +
            // ", object passed is " + obj.getClass());

            // uncomment next line to do Model Pull
            //myTextField.setText("" + model.getValue());

            // if Push
//            inputTextField.setText("" + ((Integer) obj).intValue());
        }

    }

    public void addController(ActionListener controller) {
        //System.out.println("View      : adding controller");
        buttonAddItem.addActionListener(controller);
        buttonLookup.addActionListener(controller);
        buttonExit.addActionListener(controller);
    }


    public void setValue(String v) {
        error = false;
        buttonAddItem.setEnabled(true);
        buttonLookup.setEnabled(true);
        myTextField.setText(v);
    }
    public void setError(String v) {
        error = true;
        buttonAddItem.setEnabled(false);
        buttonLookup.setEnabled(false);
        myTextField.setText(v);
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    public void sendClass(Controller c, Model m){
        m.addObserver(this);
        c.addView(this);
    }

}
