package menu.factory.app.game;

import menu.api.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultStoreMenuFactory extends StoreMenuFactory {
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("Settings Menu", "Displaying Settings Menu...", items);
    }
}
