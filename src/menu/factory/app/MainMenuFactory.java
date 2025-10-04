package menu.factory.app;

import dispatcher.api.*;
import dispatcher.console.ConsoleDispatcher;
import menu.api.*;
import menu.factory.app.game.GameModeMenuFactory;
import menu.factory.app.game.StoreMenuFactory;
import menu.factory.app.player.InventoryMenuFactory;
import menu.factory.app.player.PlayerMenuFactory;

import java.util.*;

public class MainMenuFactory extends MenuFactory{
    private Dispatcher dispatcher;
    private UtilityMenuFactory utilityMenu;
    private GameModeMenuFactory gameModeMenu;
    private StoreMenuFactory storeMenu;
    private InventoryMenuFactory inventoryMenu;
    private PlayerMenuFactory playerMenu;

    public MainMenuFactory(Dispatcher dispatcher,
                           UtilityMenuFactory utilityMenu,
                           GameModeMenuFactory gameModeMenu,
                           StoreMenuFactory storeMenu,
                           InventoryMenuFactory inventoryMenu,
                           PlayerMenuFactory playerMenu) {
        this.dispatcher = dispatcher;
        this.utilityMenu = utilityMenu;
        this.gameModeMenu = gameModeMenu;
        this.storeMenu = storeMenu;
        this.inventoryMenu = inventoryMenu;
        this.playerMenu = playerMenu;
    }

    @Override
    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addExitItem(items, dispatcher);
        items.add(action("Start Game", "Starting game...", ()-> MenuTransition.mainMenu()));
        items.add(gameModeMenu.create());
        items.add(storeMenu.create());
        items.add(inventoryMenu.create());
        items.add(utilityMenu.create());

        return menu("Main Menu", "Displaying Main Menu... ", items);
    }
}