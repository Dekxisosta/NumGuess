package app.setup;

import ui.console.ConsoleUI;

public class AppConfig {
    private UIConfig uiConfig;
    private EngineConfig engineConfig;
    private MenuConfig menuConfig;
    private DispatcherConfig dispatcherConfig;

    public AppConfig(){
        uiConfig = new UIConfig();
        dispatcherConfig = new DispatcherConfig(uiConfig.getUI());
        engineConfig = new EngineConfig();
        menuConfig = new MenuConfig();
    }
}
