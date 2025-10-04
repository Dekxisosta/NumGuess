package app.setup;

import ui.api.UI;
import ui.console.*;

import java.io.*;

public class UIConfig {
    private UI ui;

    public UIConfig(){
        ui = new ConsoleUI(
                new ConsoleReader(new BufferedReader(new InputStreamReader(System.in))),
                new ConsoleOutput());
    }

    public UI getUI(){return ui;}
}
