package menu.factory.app;

import dispatcher.api.*;
import menu.api.*;
import menu.factory.app.game.DefaultGameModeMenuFactory;
import menu.factory.app.game.DefaultStoreMenuFactory;
import menu.factory.app.player.DefaultInventoryMenuFactory;
import menu.factory.app.player.DefaultPlayerMenuFactory;

import java.util.*;

public class DefaultMainMenuFactory extends MainMenuFactory{
    private Dispatcher dispatcher;
    private UtilityMenuFactory utilityMenu;
    private GameModeMenuFactory gameModeMenu;
    private StoreMenuFactory storeMenu;
    private InventoryMenuFactory inventoryMenu;
    private PlayerMenuFactory playerMenu;

    public DefaultMainMenuFactory(Dispatcher dispatcher,
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