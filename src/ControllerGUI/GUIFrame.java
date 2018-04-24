package ControllerGUI;


import javax.swing.*;

public class GUIFrame {
    public GUIFrame() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        button.setBounds(130, 100, 100, 40);
        frame.add(button);
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
