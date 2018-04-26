package ControllerGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends View {

    private JTextArea textArea;

    public MainView(int vertPos){
        model = new Model();

        textArea = new JTextArea("Welcome to the Inventory Tracker.\n" +
                                "This program manages the inventory of\n" +
                                "a department store through a SQL database!", 5, 20);
        frame = new JFrame("Inventory Tracking Service");
        frame.add("North", new JLabel("Welcome to the Inventory Tracker, please choose an option"));

        JPanel panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        buttonAddItem = new JButton("Add Item");
        panel.add(buttonAddItem);
        buttonLookup = new JButton("Item Lookup");
        panel.add(buttonLookup);
        buttonRemove = new JButton("Delete Item");
        panel.add(buttonRemove);
        buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        panel.add(textArea, BorderLayout.LINE_START);

        frame.add("South", panel);

        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(145, 245, 215));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);

        frame.addWindowListener(new MainView.CloseListener());
        frame.setSize(500, 300);
        frame.setLocation(100, vertPos);

        frame.setVisible(true);
    }

    public void sendClass(Controller c, Model m){
        m.addObserver(this);
        c.addView(this);
    }

    public void addController(ActionListener controller) {
        buttonAddItem.addActionListener(controller);
        buttonLookup.addActionListener(controller);
        buttonRemove.addActionListener(controller);
        buttonExit.addActionListener(controller);
    }
}
