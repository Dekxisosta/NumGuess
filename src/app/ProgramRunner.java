package app;

import dispatcher.ConsoleDispatcher;
import menu.*;

class ProgramRunner {
    private boolean isRunning = true;
    private ConsoleDispatcher dispatcher;
    ProgramRunner(ConsoleDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    void run(){
        MenuResult currentMenu = dispatcher.mainMenu();

        while(isRunning){
            switch(currentMenu){
                case MAIN_MENU: currentMenu = dispatcher.mainMenu(); break;
                case SETTINGS_MENU: currentMenu = dispatcher.settingsMenu(); break;
                case EXIT:
                    System.out.printf("Performed exit");
                    isRunning = false;
                    break;
            }
        }
    }
}
