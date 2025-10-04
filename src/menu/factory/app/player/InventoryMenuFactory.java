package menu.factory.app.player;

import domain.Difficulty;
import menu.api.Menu;
import menu.api.MenuFactory;
import menu.api.MenuItem;
import menu.api.MenuTransition;

import java.util.ArrayList;
import java.util.List;

public class InventoryMenuFactory extends MenuFactory {
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("Inventory", "Displaying inventory...", items);
    }
}
