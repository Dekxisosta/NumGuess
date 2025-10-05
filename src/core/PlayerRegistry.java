package core;

public class PlayerRegistry {
    private Player[] leaderboard;
    private int leaderboardSize = 0;
    private int leaderboardCapacity = 1;

    private Player[] currentPlayers = new Player[4];
    private int currentPlayerCount=0;



    public PlayerRegistry(){
        leaderboard = new Player[leaderboardCapacity];
    }
    void addPlayer(Player player){
        if(leaderboardSize==leaderboardCapacity)
            increaseLeaderboardCapacity();
        leaderboard[leaderboardSize++] = player;
        currentPlayers[currentPlayerCount++] = player;
    }

    Player[] getPlayerData(){
        return leaderboard;
    }

    Player[] getCurrentPlayers(){
        return currentPlayers;
    }
    Player getCurrentPlayerFromIndex(int index){
        return currentPlayers[index];
    }

    int getCurrentPlayerCount(){
        return currentPlayerCount;
    }

    boolean doesPlayerNameExist(String name){
        for(Player p: leaderboard)
            if(name.equalsIgnoreCase(p.getName()))
                return true;

        return false;
    }

    private void increaseLeaderboardCapacity(){
        Player[] temp = new Player[leaderboardCapacity];
        for(int i=0;i<leaderboardCapacity;i++)
            temp[i] = leaderboard[i];

        leaderboardCapacity*=2;
        leaderboard=temp;
    }
}
