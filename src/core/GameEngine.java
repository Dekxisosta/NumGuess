package core;

public class GameEngine {
    private GameState gameState;

    public GameEngine(){
        gameState = new GameState();
    }
    public void setDifficulty(Difficulty difficulty){
        gameState.setDifficulty(difficulty);
    }
    public Difficulty getDifficulty(){
        return gameState.getDifficulty();
    }
}
