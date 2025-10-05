package menu.api;

import dispatcher.api.*;

import java.util.*;

public abstract class ExitableMenuFactory extends MenuFactory{
    protected void addExitItem (List<MenuItem> items, Dispatcher dispatcher){
        items.add(action("Exit", "Terminating program...",
                ()->{
                    if(dispatcher.promptTermination()) return MenuTransition.exit();
                    else return MenuTransition.mainMenu();
                }));
    }
}
