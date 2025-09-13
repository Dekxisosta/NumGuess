package app;

/* =======================================================
 *          NUMBER GUESSING PROGRAM
 * ====================================================== */

/**
 * A basic number guessing game made under an hour
 */
public class Main {
    /** Serves as the entry point of the program */
    public static void main(String[] args) {
        try{
            new Main().run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Runs the program
     */
    private void run(){
        PlayerRegistry playerRegistry = new PlayerRegistry();
        Game game = new Game(playerRegistry);

        playerRegistry.addPlayer(new Player("Dekxi"));

        while(true){
            game.start();
        }
    }
}

/**
 * Player object
 */
