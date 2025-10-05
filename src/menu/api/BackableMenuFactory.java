package menu.api;

import java.util.*;

public abstract class BackableMenuFactory extends MenuFactory{
    protected void addBackItem(List<MenuItem> items) {
        items.add(action("Back", "Returning...", () -> MenuTransition.mainMenu()));
    }
}
