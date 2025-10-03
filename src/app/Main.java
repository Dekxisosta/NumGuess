package app;

/* =======================================================
 *          NUMBER GUESSING PROGRAM
 * ====================================================== */

import app.setup.*;
import dispatcher.*;
import domain.PlayerRegistry;
import engine.*;
import menu.factory.app.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A basic number guessing game made under an hour
 */
public class Main {
    public static void main(String[] args) {
        MainMenuFactory menuFactory = new MainMenuFactory(engineConfig.getEngine());
        ConsoleDispatcher dispatcher = new ConsoleDispatcher(uiConfig.getUI(), menuFactory);

        PlayerRegistry playerRegistry = new PlayerRegistry();
//        GameEngine gameEngine = new GameEngine(playerRegistry);

        ProgramRunner runner = new ProgramRunner(dispatcher);

        try {
            runner.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
