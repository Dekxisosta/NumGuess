package ui.console;

import common.Logger;

public class ConsoleOutput {
    public void printOptions(String[] options){
        for(int i=1;i<options.length;i++)
            System.out.printf("%n[%d] %s", i, options[i]);

        System.out.printf("%n[%d] %s", 0, options[0]);
    }

    public void printBanner(String s){
        printBorder(s.length() + 6);
        System.out.printf("%n{| %s |}", s);
        printBorder(s.length() + 6);
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
