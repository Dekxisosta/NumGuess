package menu.factory.app;

import menu.api.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultUtilityMenuFactory extends UtilityMenuFactory {
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("Settings Menu", "Displaying Settings Menu...", items);
    }
}
