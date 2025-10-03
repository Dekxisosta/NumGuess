package app.setup;

public class AppFactory {
    private UIConfig uiConfig;
    private EngineConfig engineConfig;
    private MenuConfig menuConfig;

    public AppFactory(){
        uiConfig = new UIConfig();
        engineConfig = new EngineConfig();
        menuConfig = new MenuConfig(uiConfig.getUI());
    }
}
