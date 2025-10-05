package menu.factory.app.player;

import menu.api.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultInventoryMenuFactory extends InventoryMenuFactory {
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("Inventory", "Displaying inventory...", items);
    }
}
