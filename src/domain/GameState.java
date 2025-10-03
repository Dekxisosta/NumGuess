package domain;

public class GameState {
    private Difficulty difficulty;
    private PlayerRegistry registry;

    public GameState(){
        difficulty = Difficulty.NORMAL;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }
}
