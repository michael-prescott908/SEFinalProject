package ControllerGUI;

import  Table.Table;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LookupView extends View {
    private JButton Cancel;
    public LookupView(int vertPos){
        model = new Model();

        frame = new JFrame("Inventory Tracking Service");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Table newPane = new Table();
        newPane.setOpaque(true);
        frame.setContentPane(newPane);
        frame.add("North", new Label("Current Inventory"));

        JPanel panel = new JPanel();
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
        Cancel.addActionListener(controller);
    }
}
