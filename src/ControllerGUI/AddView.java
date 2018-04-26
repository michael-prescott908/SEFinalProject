package ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddView extends View {
    private JButton Add;
    private JButton Cancel;

    public AddView(int vertPos){
        model = new Model();

        frame = new JFrame("Inventory Tracking Service");
        frame.add("North", new Label("Please fill out information to add new item"));


        addPrice = new JTextField();
        addName = new JTextField();
        addSerial = new JTextField();

        JPanel panel1 = new JPanel(new GridLayout(3,2));
        panel1.add(new JLabel("Price: "));
        panel1.add(addPrice);
        panel1.add(new JLabel("Name: "));
        panel1.add(addName);
        panel1.add(new JLabel("Serial: "));
        panel1.add(addSerial);

        panel1.setSize(200, 100);
        panel1.setLocation(150, 100);

        JPanel panel2 = new JPanel();
        Add = new JButton("Insert");
        panel2.add(Add);
        Cancel = new JButton("Cancel");
        panel2.add(Cancel);

        frame.add("Center", panel1);
        frame.add("South", panel2);

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
        Add.addActionListener(controller);
        Cancel.addActionListener(controller);
    }
}
