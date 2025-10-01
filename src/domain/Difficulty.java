package domain;

enum Difficulty {
    EASY(10, "EASY"),
    NORMAL(20, "NORMAL"),
    HARD(30, "HARD"),
    EXPERT(50, "EXPERT"),
    HACKER(100, "HACKER");

    private int range;
    private String label;
    Difficulty(int range, String label){
        this.range = range;
        this.label = label;
    }

    int range(){return range;}
    String label(){return label;}
}
