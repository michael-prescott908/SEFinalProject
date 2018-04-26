package ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RemoveView extends View {
    private JButton Remove;
    private JButton Cancel;

    public RemoveView(int vertPos){
        model = new Model();

        frame = new JFrame("Inventory Tracking Service");
        frame.add("North", new Label("Please fill out information to remove item"));

        remSerial = new JTextField();

        JPanel panel1 = new JPanel(new GridLayout(1,2));
        panel1.add(new JLabel("Serial No.: "));
        panel1.add(remSerial);

        panel1.setSize(200, 30);
        panel1.setLocation(150, 100);

        JPanel panel2 = new JPanel();
        Remove = new JButton("Remove");
        panel2.add(Remove);
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
        Remove.addActionListener(controller);
        Cancel.addActionListener(controller);
    }
}
