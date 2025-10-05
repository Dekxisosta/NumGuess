package core;

/**
 * Player class. Has name, points, and wins
 */
class Player{
    private static int id = 100000;

    /** Field for player's userID */
    private int userID;

    /** Field for player's names */
    private String name;

    /** Field for player's wins */
    private int wins;

    /** Field for player's current game points */
    private int points;

    /** Field for player's overall garnered points */
    private int overallPoints;

    /**
     * Constructor for player object
     * @param name name of the player
     */
    Player(String name){
        this.userID = id++; // allocates current id value, then increments for next player
        this.name = name;
        this.wins = 0;
        this.points = 0;
    }

    /** @return name of the player */
    String getName(){return name;}

    /** @return total wins of the player */
    int getWins(){return wins;}

    /** @return total points of the player*/
    int getPoints(){return points;}

    /** Resets points of the player */
    void resetPoints(){this.points = 0;}

    /** Adds points to player */
    void addPoints(int points){
        this.points += points;
        overallPoints += points;
    }


    /** Adds a win to player */
    void addWin(){wins++;}
}