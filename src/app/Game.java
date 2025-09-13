package app;

class Game {
    private PlayerRegistry playerRegistry;
    private UI ui = new UI();

    Game(PlayerRegistry playerRegistry){
        this.playerRegistry = playerRegistry;
    }


    String[] options = {
            "Play",
            "Show Leaderboard",
            "Exit game"
    };
    void start(){
        int difficulty = getNumberRange();
        int min = generateNumber(0,20);
        int max = min + difficulty;

        int number = generateNumber(min, max);

        boolean isSolved = false;

        while(!isSolved){
            ui.showMessage(ConsoleTag.GAME, "I'm thinking of a number between %d-%d", min, max);

            for(int i=0;i< playerRegistry.getCurrentPlayerCount(); i++){
                Player p = playerRegistry.getCurrentPlayerFromIndex(i);

                ui.showMessage(ConsoleTag.GAME,"It's %s's turn!", p.getName());
                ui.showEnterPrompt("guess");

                int guess = ui.getInt();

                isSolved = number == guess;

                if(isSolved){
                    ui.showMessage(ConsoleTag.GAME, "%s guessed the number!", p.getName());
                    break;
                }else{
                    if(guess>number)
                        ui.showMessage(ConsoleTag.GAME, "%s lower next time!", p.getName());
                    else
                        ui.showMessage(ConsoleTag.GAME, "%s higher next time!", p.getName());
                }


            }
        }
    }

    int getNumberRange(){
        ui.showBanner("CHOOSE DIFFICULTY");
        ui.showOptions(new String[]{
                "BACK",
                Difficulty.EASY.name(),
                Difficulty.NORMAL.name(),
                Difficulty.HARD.name(),
                Difficulty.EXPERT.name()
        });
        ui.showEnterPrompt("difficulty");

        int choice = ui.getIntWithRange(0,4);
        switch(choice){
            case 1:
                return Difficulty.EASY.range();
            case 2:
                return Difficulty.NORMAL.range();
            case 3:
                return Difficulty.HARD.range();
            case 4:
                return Difficulty.EXPERT.range();
            case 0:
                return 0;
        }

        throw new IllegalStateException("Difficulty out of bounds");
    }
    int generateNumber(int min, int max){
        return (int)(Math.random() * (max-min+1)) + min;
    }
}
