package bootstrap;

import dispatcher.api.*;
import engine.*;
import menu.factory.app.*;
import menu.factory.app.game.*;
import menu.factory.app.player.*;

public class MenuSetup {
    private final MainMenuFactory mainMenuFactory;

    public MenuSetup(
            Dispatcher dispatcher,
            UtilityMenuFactory utilityMenuFactory,
            GameModeMenuFactory gameModeMenuFactory,
            StoreMenuFactory storeMenuFactory,
            InventoryMenuFactory inventoryMenuFactory,
            PlayerMenuFactory playerMenuFactory
    ) {
        this.mainMenuFactory = new MainMenuFactory(
                dispatcher,
                utilityMenuFactory,
                gameModeMenuFactory,
                storeMenuFactory,
                inventoryMenuFactory,
                playerMenuFactory
        );
    }

    public MainMenuFactory getMainMenuFactory() {
        return mainMenuFactory;
    }
}