package dispatcher.console;

import common.logging.*;
import dispatcher.api.Dispatcher;
import menu.api.*;
import menu.factory.app.*;
import ui.console.ConsoleUI;

public class ConsoleDispatcher implements Dispatcher {
    private ConsoleUI ui;
    private MainMenuFactory mainMenu;

    public ConsoleDispatcher(ConsoleUI ui, MainMenuFactory mainMenu) {
        this.ui = ui;
        this.mainMenu = mainMenu;
    }

    public void greet(){
        ui.showIntroduction();
        ui.showLineBreak();
    }

    public void goodbye(){
        ui.showLineBreak();
        ui.showConclusion();
    }

    public Menu mainMenu(){
        return mainMenu.create();
    }

    public boolean promptTermination(){
        ui.showLineBreak();
        ui.showMessage("Quit program? (y/n)", Logger.SYSTEM);
        return ui.getBoolean();
    }

    public MenuTransition execute(Menu menu){
        int choice = ui.showMenuAndGetChoice(menu.getLabel(), menu.getOptionNames());
        MenuItem option = menu.getMenuItem(choice);

        ui.showMessage(option.getSystemNotification(), Logger.SYSTEM);
        return option.execute();
    }
}
