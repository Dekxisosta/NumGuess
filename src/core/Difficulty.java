package core;

public enum Difficulty {
    EASY(10, "EASY"),
    NORMAL(20, "NORMAL"),
    HARD(30, "HARD"),
    EXPERT(50, "EXPERT"),
    HACKER(500, "HACKER"),
    IMPOSSIBLE(10000, "IMPOSSIBLE");

    private int range;
    private String label;
    Difficulty(int range, String label){
        this.range = range;
        this.label = label;
    }

    int range(){return range;}
    String label(){return label;}
}
