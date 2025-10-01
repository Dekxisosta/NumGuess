package ui.console;

import common.Logger;

/**
 * High-level UI facade for console interaction.
 * Delegates input to ConsoleReader and output to ConsoleOutput.
 */
public class ConsoleUI {

    private final ConsoleReader reader;
    private final ConsoleOutput output;

    public ConsoleUI(ConsoleReader reader, ConsoleOutput output) {
        this.reader = reader;
        this.output = output;
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
    public boolean getBoolean() {
        while(true){
            try{
                return reader.readBoolean();
            }catch(Exception e){
                showMessage(e.getMessage(), Logger.ERROR);
            }
        }
    }

    public int getInt() {
        while(true) {
            try {
                return reader.readInt();
            } catch (Exception e) {
                showMessage(e.getMessage(), Logger.ERROR);
            }
        }
    }

    public int getIntWithRange(int min, int max) {
        while(true) {
            try {
                return reader.readIntWithRange(min, max);
            } catch (Exception e) {
                showMessage(e.getMessage(), Logger.ERROR);
            }
        }
    }

    public String getString() {
        while(true) {
            try {
                return reader.readString();
            } catch (Exception e) {
                showMessage(e.getMessage(), Logger.ERROR);
            }
        }
    }

    public void close() {
        reader.close();
    }

    // ========================
    // OUTPUT DELEGATES
    // ========================
    public void showOptions(String[] options) {
        output.printOptions(options);
    }

    public void showBanner(String text) {
        output.printBanner(text);
    }

    public void showEnterPrompt() {
        output.printEnterPrompt();
    }

    public void showEnterPrompt(String type) {
        output.printEnterPrompt(type);
    }

    public void showBorder(int length) {
        output.printBorder(length);
    }

    public void showMessage(String text, Logger type) {
        output.printMessage(text, type);
    }

    public void showLineBreaks() {
        output.printLineBreak();
    }
}