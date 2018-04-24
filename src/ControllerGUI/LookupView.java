package ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LookupView extends View {
    private JButton Add;
    private JButton Cancel;
    public LookupView(int vertPos){
        JFrame frame = new JFrame("Inventory Tracking Service");
        frame.add("North", new Label("Do soome stuff"));
        JPanel panel = new JPanel();
        Add = new JButton("Add Item");
        panel.add(Add);
        Cancel = new JButton("Cancel");
        panel.add(Cancel);

    }

    public void sendClass(Controller c, Model m){
        m.addObserver(this);
        c.addView(this);
    }

    public void addController(ActionListener controller) {
        //System.out.println("View      : adding controller");
        Add.addActionListener(controller);
        Cancel.addActionListener(controller);
    }
}
