package ui.console;

import common.logging.Logger;
import config.*;

public class ConsoleOutput {
    private AppConfig config = AppConfig.getInstance();

    /** Prints a brief introduction with program details. */
    public void printIntroduction() {
        System.out.print(config.getAuthorBanner());
        System.out.print("\nPROGRAM: " + config.getProgramName()
                + "\nDate Created: " + config.getDateCreated()
                + "\nCreated by: " + config.getAuthorName());
    }

    /** Prints a conclusion message. */
    public void printConclusion() {
        System.out.print("\n" + config.getProgramName()
                + "\nThank you for using the program!! "
                + "\n- Dekxi");
    }
    public void printOptions(String[] options){
        for(int i=1;i<options.length;i++)
            System.out.printf("%n[%d] %s", i, options[i]);

        System.out.printf("%n[%d] %s", 0, options[0]);
    }

    public void printBanner(String s){
        printBorder(s.length() + 18);
        System.out.printf("%n{| %-6s%s%6s |}", " ", s, " ");
        printBorder(s.length() + 18);
    }

    public void printEnterPrompt(){
        System.out.printf("%nEnter: ");
    }

    public void printEnterPrompt(String inputType){
        System.out.printf("%nEnter %s: ", inputType);
    }

    public void printBorder(int length){
        System.out.printf("%n%s", "=".repeat(length));
    }

    public void printMessage(String text, Logger type){
        System.out.printf("%n%s %s ", type.label(), text);
    }

    public void printLineBreak(){
        System.out.println();
    }
}
