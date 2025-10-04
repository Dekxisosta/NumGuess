package menu.factory.app.game;

import menu.api.Menu;
import menu.api.MenuFactory;
import menu.api.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class StoreMenuFactory extends MenuFactory {
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("Settings Menu", "Displaying Settings Menu...", items);
    }
}
