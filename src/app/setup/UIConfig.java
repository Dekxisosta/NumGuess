package app.setup;

import ui.console.*;

import java.io.*;

public class UIConfig {
    private ConsoleReader reader;
    private ConsoleOutput output;
    private ConsoleUI ui;

    public UIConfig(){
        ConsoleReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        ConsoleOutput output = new ConsoleOutput();
        ConsoleUI ui = new ConsoleUI(reader, output);
    }

    public ConsoleReader getReader(){return reader;}
    public ConsoleOutput getOutput(){return output;}
    public ConsoleUI getUI(){return ui;}
}
