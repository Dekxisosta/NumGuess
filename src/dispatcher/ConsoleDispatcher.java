package dispatcher;

import common.*;
import menu.*;
import ui.console.ConsoleUI;

public class ConsoleDispatcher {
    private ConsoleUI ui;

    public ConsoleDispatcher(ConsoleUI ui) {
        this.ui = ui;
    }

    public MenuResult mainMenu(){
        Menu menu = new Menu(new MenuOption[]{
                new MenuOption("Quit", ()->{
                    if (promptTermination()) return MenuResult.EXIT;
                    else return MenuResult.MAIN_MENU;
                }),
                new MenuOption("Start Game", ()-> MenuResult.MAIN_MENU),
                new MenuOption("Select Game Mode", ()-> MenuResult.MAIN_MENU),
                new MenuOption("Settings", ()-> MenuResult.SETTINGS_MENU),
        });
        return handleChoice("Main Menu", menu);
    }
    public MenuResult settingsMenu(){
        Menu menu = new Menu(new MenuOption[]{
                new MenuOption("Back", ()-> MenuResult.MAIN_MENU)
        });
        return handleChoice("Settings", menu);
    }

    /* ===================
     * UTILITY METHODS
     ===================*/
    private MenuResult handleChoice(String title, Menu menu){
        int choice = ui.showMenuAndGetChoice(title, menu.getOptionNames());
        return menu.get(choice).execute();
    }
    private boolean promptTermination(){
        ui.showMessage("Quit program? (y/n)", Logger.SYSTEM);
        return ui.getBoolean();
    }

}
