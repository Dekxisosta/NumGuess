package bootstrap;

import engine.*;

public class EngineSetup {
    private GameEngine engine;
    public EngineSetup(){
        GameEngine engine = new GameEngine();
    }
    public GameEngine getEngine(){return engine;}
}
