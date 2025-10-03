package menu.factory.app.utility;

import dispatcher.*;
import menu.api.*;

import java.util.*;
import java.util.function.*;

public class FactoryHelper {
    public FactoryHelper(){}

    public void addEnumItems(List<MenuItem> items, Supplier<MenuTransition> actionSupplier, Enum<?>... enums) {
        for (Enum<?> e : enums)
            items.add(action(e.name(), "Selected " + e.name() + "!", actionSupplier));
    }
    public void addExitItem(List<MenuItem> items, ConsoleDispatcher dispatcher){
        items.add(action("Exit", "Terminating program...",
                ()->{
                    if(dispatcher.promptTermination()) return MenuTransition.exit();
                    else return MenuTransition.mainMenu();
                }));
    }
    public ActionItem action(String label, String systemNotification, Supplier<MenuTransition> action){
        return new ActionItem(label, systemNotification, action);
    }
    public Menu menu(String label, String systemNotification, List<MenuItem> options){
        return new Menu(label, systemNotification, options);
    }
    public void addBackItem(List<MenuItem> items) {
        items.add(action("Back", "Returning...", () -> MenuTransition.mainMenu()));
    }
}
