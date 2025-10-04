package menu.api;

import dispatcher.api.*;

import java.util.List;
import java.util.function.Supplier;

public abstract class MenuFactory {
    public abstract Menu create();
    protected void addExitItem (List<MenuItem> items, Dispatcher dispatcher){
        items.add(action("Exit", "Terminating program...",
                ()->{
                    if(dispatcher.promptTermination()) return MenuTransition.exit();
                    else return MenuTransition.mainMenu();
                }));
    }
    protected Menu menu(String label, String systemNotification, List<MenuItem> options){
        return new Menu(label, systemNotification, options);
    }
    protected void addBackItem(List<MenuItem> items) {
        items.add(action("Back", "Returning...", () -> MenuTransition.mainMenu()));
    }
    protected ActionItem action(String label, String systemNotification, Supplier<MenuTransition> action){
        return new ActionItem(label, systemNotification, action);
    }
}
