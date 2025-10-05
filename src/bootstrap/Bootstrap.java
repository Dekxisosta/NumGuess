package bootstrap;

import core.*;
import dispatcher.api.*;
import dispatcher.console.*;
import menu.api.*;
import menu.factory.app.*;
import menu.factory.app.game.*;
import menu.factory.app.player.*;
import ui.api.*;
import ui.console.*;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Bootstrap {
    public Bootstrap(){}
    public DIContainer init(){
        DIContainer container = new DIContainer();

        container.register(InputStreamReader.class, ()-> new InputStreamReader(System.in));
        container.register(BufferedReader.class, ()-> new BufferedReader(container.resolve(InputStreamReader.class)));
        container.register(ConsoleReader.class, ()-> new ConsoleReader(container.resolve(BufferedReader.class)));
        container.register(ConsoleRenderer.class, ConsoleRenderer::new);
        container.register(UI.class,
                ()-> new ConsoleUI(
                        container.resolve(ConsoleReader.class),
                        container.resolve(ConsoleRenderer.class)
                )
        );

        container.register(ConsoleDispatcher.class, ()-> new ConsoleDispatcher(container.resolve(UI.class)));
        container.register(Dispatcher.class, ()-> container.resolve(ConsoleDispatcher.class));

        container.register(GameEngine.class, ()-> new GameEngine());

        container.register(DefaultUtilityMenuFactory.class, ()-> new DefaultUtilityMenuFactory());
        container.register(UtilityMenuFactory.class, ()-> container.resolve(DefaultUtilityMenuFactory.class));

        container.register(DefaultGameModeMenuFactory.class,
                ()-> new DefaultGameModeMenuFactory(
                        container.resolve(GameEngine.class)
                ));
        container.register(GameModeMenuFactory.class, ()-> container.resolve(DefaultGameModeMenuFactory.class));

        container.register(DefaultStoreMenuFactory.class, ()-> new DefaultStoreMenuFactory());
        container.register(StoreMenuFactory.class, ()-> container.resolve(DefaultStoreMenuFactory.class));

        container.register(DefaultInventoryMenuFactory.class, ()-> new  DefaultInventoryMenuFactory());
        container.register(InventoryMenuFactory.class, ()-> container.resolve(DefaultInventoryMenuFactory.class));

        container.register(DefaultPlayerMenuFactory.class, ()-> new DefaultPlayerMenuFactory());
        container.register(PlayerMenuFactory.class, ()-> container.resolve(DefaultPlayerMenuFactory.class));

        container.register(DefaultMainMenuFactory.class,
                ()-> new DefaultMainMenuFactory(
                        container.resolve(Dispatcher.class),
                        container.resolve(UtilityMenuFactory.class),
                        container.resolve(GameModeMenuFactory.class),
                        container.resolve(StoreMenuFactory.class),
                        container.resolve(InventoryMenuFactory.class),
                        container.resolve(PlayerMenuFactory.class)
                )
        );
        container.register(MainMenuFactory.class, ()-> container.resolve(DefaultMainMenuFactory.class));

        return container;
    }
}
