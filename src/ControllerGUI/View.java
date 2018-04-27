package ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.lang.Integer;
import java.util.Observable;
import java.awt.event.ActionListener;

/**
 * Class: View
 *  View inherits from the Observer class and
 *  serves as generic to the specialized Views
 */
public class View implements java.util.Observer {

    protected TextField myTextField;
    protected JButton buttonAddItem;
    protected JButton buttonLookup;
    protected JButton buttonExit;
    protected JButton buttonRemove;
    protected Model model;
    protected JFrame frame;
    protected JTextField addPrice;
    protected JTextField addName;
    protected JTextField addSerial;
    protected JTextField remSerial;

    protected boolean error = false;

    public View(){}

    public void update(Observable obs, Object obj) {}

    public void addController(ActionListener controller) {
        //System.out.println("View      : adding controller");
        buttonAddItem.addActionListener(controller);
        buttonLookup.addActionListener(controller);
        buttonRemove.addActionListener(controller);
        buttonExit.addActionListener(controller);
    }


    public void setValue(String v) {
        error = false;
        buttonAddItem.setEnabled(true);
        buttonLookup.setEnabled(true);
        buttonRemove.setEnabled(true);
        myTextField.setText(v);
    }
    public void setError(String v) {
        error = true;
        buttonAddItem.setEnabled(false);
        buttonLookup.setEnabled(false);
        buttonRemove.setEnabled(false);
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

    public JFrame getFrame(){
        return frame;
    }

    public JTextField getAddPrice() {
        return addPrice;
    }

    public JTextField getAddName() {
        return addName;
    }

    public JTextField getAddSerial() {
        return addSerial;
    }

    public JTextField getRemSerial(){
        return remSerial;
    }
}
