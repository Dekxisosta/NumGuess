package app;

/* =======================================================
 *          NUMBER GUESSING PROGRAM
 * ====================================================== */

import data.*;
import dispatcher.*;
import domain.PlayerRegistry;
import engine.*;
import ui.console.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A basic number guessing game made under an hour
 */
public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        ConsoleOutput output = new ConsoleOutput();
        ConsoleUI ui = new ConsoleUI(reader, output);

        ConsoleDispatcher dispatcher = new ConsoleDispatcher(ui);

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
