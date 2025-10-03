package app.setup;

import engine.*;

public class EngineConfig {
    private GameEngine engine;

    public EngineConfig(){
        GameEngine engine = new GameEngine();
    }

    public GameEngine getEngine(){return engine;}
}
