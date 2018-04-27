package ControllerGUI;

import Factory.CreateFrame;
import Table.MyTableModel;

import java.util.HashSet;

/**
 * Class: RunGUI
 *  RunGUI serves as an abstraction of the main function
 */
public class RunGUI {
    private View view;

    public RunGUI(String command) {

        view = CreateFrame.createFrame(command);

        Model model = new Model();
        model.addObserver(view);

        Controller controller = new Controller();
        controller.addModel(model);
        view.sendClass(controller, model);

        view.addController(controller);
    }

}
