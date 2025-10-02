package common.menu;

import dispatcher.*;
import domain.*;

import java.util.*;
import java.util.function.*;

public class MenuFactory {
    public MenuFactory(){}
    /** Creates a main menu / root menu */
    public Menu createMainMenu(ConsoleDispatcher dispatcher){
        List<MenuItem> items = new ArrayList<>();
        addExitItem(items, dispatcher);
        items.add(action("Start Game", "Starting game...", ()-> MenuTransition.mainMenu()));
        items.add(createGameModeMenu());
        items.add(createStoreMenu());
        items.add(createInventoryMenu());
        items.add(createSettingsMenu());

        return menu("Main Menu", "Displaying Main Menu... ", items);
    }

    /** Creates a settings menu */
    public Menu createSettingsMenu(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        return menu("Settings Menu", "Displaying Settings Menu...", items);
    }

    /** Creates a game mode menu */
    public Menu createGameModeMenu(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        addEnumItems(items, ()->MenuTransition.mainMenu(), Difficulty.values());
        return menu("Game Mode Menu", "Displaying Game Mode Menu...", items);
    }
    /** Creates a game mode menu */
    public Menu createStoreMenu(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        addEnumItems(items, ()->MenuTransition.mainMenu(), Difficulty.values());
        return menu("Store Menu", "Displaying Store items...", items);
    }
    /** Creates a game mode menu */
    public Menu createInventoryMenu(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        addEnumItems(items, ()->MenuTransition.mainMenu(), Difficulty.values());
        return menu("Inventory", "Displaying inventory...", items);
    }

    /*===================================
     *  UTILITY METHODS
     ==================================*/
    private void addEnumItems(List<MenuItem> items, Supplier<MenuTransition> actionSupplier, Enum<?>... enums) {
        for (Enum<?> e : enums)
            items.add(action(e.name(), "Selected " + e.name() + "!", actionSupplier));
    }
    private void addExitItem(List<MenuItem> items, ConsoleDispatcher dispatcher){
        items.add(action("Exit", "Terminating program...",
                ()->{
                    if(dispatcher.promptTermination()) return MenuTransition.exit();
                    else return MenuTransition.mainMenu();
                }));
    }
    private ActionItem action(String label, String systemNotification, Supplier<MenuTransition> action){
        return new ActionItem(label, systemNotification, action);
    }
    private Menu menu(String label, String systemNotification, List<MenuItem> options){
        return new Menu(label, systemNotification, options);
    }
    private void addBackItem(List<MenuItem> items) {
        items.add(action("Back", "Returning...", () -> MenuTransition.mainMenu()));
    }
}