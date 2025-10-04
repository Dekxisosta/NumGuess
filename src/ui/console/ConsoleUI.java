package ui.console;

import common.logging.Logger;
import ui.api.UI;

import java.util.function.Supplier;

public class ConsoleUI implements UI {

    private final ConsoleReader reader;
    private final ConsoleOutput output;

    public ConsoleUI(ConsoleReader reader, ConsoleOutput output) {
        this.reader = reader;
        this.output = output;
    }
    public void showIntroduction(){
        output.printIntroduction();
    }
    public void showConclusion(){
        output.printConclusion();
    }
    public int showMenuAndGetChoice(String title, String[] options){
        showBanner(title);
        showOptions(options);
        showEnterPrompt("choice");
        return getIntWithRange(0, options.length-1);
    }

    // ========================
    // INPUT DELEGATES
    // ========================
    public boolean getBoolean() {return getWrapper(reader::readBoolean);}

    public int getInt() {return getWrapper(reader::readInt);}

    public int getIntWithRange(int min, int max) {return getWrapper(()->reader.readIntWithRange(min, max));}

    public String getString() {return getWrapper(reader::readString);}

    public void close() {reader.close();}

    // ========================
    // OUTPUT DELEGATES
    // ========================
    public void showOptions(String[] options) {output.printOptions(options);}

    public void showBanner(String text) {output.printBanner(text);}

    public void showEnterPrompt() {output.printEnterPrompt();}

    public void showEnterPrompt(String type) {output.printEnterPrompt(type);}

    public void showBorder(int length) {output.printBorder(length);}

    public void showMessage(String text, Logger type) {output.printMessage(text, type);}

    public void showLineBreak() {output.printLineBreak();}

    // ========================
    // UTILITY FUNCTIONS
    // ========================
    private <T> T getWrapper(Supplier<T> getter){
        while(true) {
            try {
                return getter.get();
            } catch (Exception e) {
                showMessage(e.getMessage(), Logger.ERROR);
                showEnterPrompt();
            }
        }
    }
}