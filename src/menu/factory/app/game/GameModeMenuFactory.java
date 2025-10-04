package menu.factory.app.game;

import domain.*;
import engine.GameEngine;
import menu.api.*;

import java.util.List;
import java.util.ArrayList;

public class GameModeMenuFactory extends MenuFactory {
    private GameEngine gameEngine;
    public GameModeMenuFactory(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public Menu create(){
        List<MenuItem> items = new ArrayList<>();
        addBackItem(items);
        addGameModes(items, Difficulty.values());
        return menu("Game Mode Menu", "Displaying Game Mode Menu...", items);
    }

    private void addGameModes(List<MenuItem> items, Difficulty... modes){
        for (Difficulty mode : modes)
            items.add(action(mode.name(), "Selected " + mode.name() + "!", ()->{
                gameEngine.setDifficulty(mode);
                return MenuTransition.mainMenu();
            }));
    }
}
