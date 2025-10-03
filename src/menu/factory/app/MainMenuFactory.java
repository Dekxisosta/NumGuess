package menu.factory.app;

import dispatcher.*;
import domain.*;
import engine.*;
import menu.api.*;

import java.util.*;
import java.util.function.*;

public class MainMenuFactory {
    private GameEngine gameEngine;


    public MainMenuFactory(GameEngine gameEngine){
       this.gameEngine = gameEngine;
    }

    /** Creates a main menu / root menu */
    public Menu createMainMenu(ConsoleDispatcher dispatcher){
        List<MenuItem> items = new ArrayList<>();
        addExitItem(items, dispatcher);
        items.add(action("Start Game", "Starting game...", ()-> {
            System.out.println(gameEngine.getDifficulty().name());
            return MenuTransition.mainMenu();
        }));
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
    public Menu createStoreMenu(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        addEnumItems(items, ()->MenuTransition.mainMenu(), Difficulty.values());
        return menu("Buy Cosmetics!", "Displaying Store items...", items);
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
    private void addGameModes(List<MenuItem> items, Difficulty... modes){
        for (Difficulty mode : modes)
            items.add(action(mode.name(), "Selected " + mode.name() + "!", ()->{
                gameEngine.setDifficulty(mode);
                return MenuTransition.mainMenu();
            }));
    }

}