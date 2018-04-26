package ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddView extends View {
    private JButton Add;
    private JButton Cancel;
    public AddView(int vertPos){
        model = new Model();
        model.setValue(10);

        frame = new JFrame("Inventory Tracking Service");
        frame.add("North", new Label("Please fill out information to add new item"));

        JPanel panel = new JPanel();
        Add = new JButton("Add Item");
        panel.add(Add);
        Cancel = new JButton("Cancel");
        panel.add(Cancel);

        frame.add("South", panel);

        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(145, 245, 215));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);

        frame.addWindowListener(new AddView.CloseListener());
        frame.setSize(500, 400);
        frame.setLocation(100, vertPos);
        frame.setVisible(true);
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
