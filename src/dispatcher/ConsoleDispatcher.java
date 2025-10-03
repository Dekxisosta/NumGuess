package dispatcher;

import common.logging.*;
import menu.api.*;
import menu.factory.app.*;
import ui.console.ConsoleUI;

public class ConsoleDispatcher {
    private ConsoleUI ui;
    private MainMenuFactory menuFactory;

    public ConsoleDispatcher(ConsoleUI ui, MainMenuFactory menuFactory) {
        this.ui = ui;
        this.menuFactory = menuFactory;
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
        return menuFactory.createMainMenu(this);
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
