package app;

import bootstrap.*;
import dispatcher.api.*;
import dispatcher.console.ConsoleDispatcher;
import menu.api.*;

class ProgramRunner {
    private boolean isRunning = true;
    private DIContainer container;

    ProgramRunner(DIContainer container){
        this.container = container;
    }

    void run(){
        Dispatcher dispatcher = container.resolve(Dispatcher.class);
        MainMenuFactory mainMenu = container.resolve(MainMenuFactory.class);

        dispatcher.greet();
        Menu current = mainMenu.create();

        while(isRunning){
            MenuTransition transition = dispatcher.execute(current);
            switch (transition.getType()) {
                case MAIN_MENU:
                    current = mainMenu.create();
                    break;
                case SUBMENU:
                    current = transition.getSubmenu();
                    break;
                case EXIT:
                    System.out.println("Performed exit");
                    isRunning = false;
                    break;
            }
        }
        dispatcher.goodbye();
    }
}
