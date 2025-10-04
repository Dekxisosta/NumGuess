package bootstrap;

import dispatcher.api.*;
import dispatcher.console.*;
import ui.api.UI;

public class DispatcherSetup {
    private Dispatcher dispatcher;
    public DispatcherSetup(UI ui){this.dispatcher = new ConsoleDispatcher(ui);}
    public DispatcherSetup(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
    }
    public Dispatcher getDispatcher(){return dispatcher;}
}
