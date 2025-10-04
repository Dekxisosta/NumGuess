package bootstrap;

import ui.api.UI;
import ui.console.*;
import java.io.*;

public class UISetup {
    private UI ui;

    public UISetup(){
        this.ui = new ConsoleUI(
                new ConsoleReader(new BufferedReader(new InputStreamReader(System.in))),
                new ConsoleOutput());
    }
    public UISetup(UI ui){
        this.ui = ui;
    }

    public UI getUI(){return ui;}
}
