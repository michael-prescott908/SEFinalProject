package Factory;

import ControllerGUI.*;

/**
 * Class: CreateFrame
 *  CreateFrame serves as a factory for creating the different
 *  types of Views and also serves as a singleton since there
 *  is never more than one instance of CreateFrame
 */
public class CreateFrame {
    public static View createFrame(String command){
        View view = null;
        switch(command){
            case "Basic": view = new MainView(10); break;
            case "Add Item": view = new AddView(10); break;
            case "Item Lookup": view = new LookupView(10); break;
            case "Delete Item": view = new RemoveView(10); break;
            default: System.out.println("Didn't work"); break;
        }
        return view;
    }
}
