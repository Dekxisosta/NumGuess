package menu.factory.app.game;

import domain.*;
import menu.api.*;

import java.util.List;
import java.util.ArrayList;

public class GameModeFactory {
    /** Creates a game mode menu */
    public Menu createGameModeMenu(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        addGameModes(items, Difficulty.values());
        return menu("Game Mode Menu", "Displaying Game Mode Menu...", items);
    }

}
