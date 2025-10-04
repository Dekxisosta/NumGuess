package app;

import dispatcher.console.ConsoleDispatcher;
import menu.api.*;

class ProgramRunner {
    private boolean isRunning = true;
    private ConsoleDispatcher dispatcher;
    ProgramRunner(ConsoleDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    void run(){
        dispatcher.greet();
        Menu current = dispatcher.mainMenu();

        while(isRunning){
            MenuTransition transition = dispatcher.execute(current);
            switch (transition.getType()) {
                case MAIN_MENU:
                    current = dispatcher.mainMenu();
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
