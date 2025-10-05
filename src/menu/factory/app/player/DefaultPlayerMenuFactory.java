package menu.factory.app.player;

import menu.api.*;

import java.util.*;

public class DefaultPlayerMenuFactory extends PlayerMenuFactory {
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("View Players", "Showing player stats...", items);
    }
}
