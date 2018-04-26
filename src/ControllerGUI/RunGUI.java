package ControllerGUI;

import Factory.CreateFrame;
import Items.Item;
import Table.MyTableModel;

import java.util.HashSet;

public class RunGUI {


    private int start_value = 10;
    private View view;

    public RunGUI(String command) {

        view = CreateFrame.createFrame(command);
        System.out.println(view.getClass());
        Model model = new Model();
        model.addObserver(view);

        Controller controller = new Controller();
        controller.addModel(model);
        view.sendClass(controller, model);

        view.addController(controller);
        model.setValue(start_value);
    }

}
