package ui.console;

import common.logging.Logger;
import config.*;
import ui.api.*;

public class ConsoleRenderer implements OutputRenderer {
    private AppConfig config = AppConfig.getInstance();

    public void printIntroduction() {
        System.out.print(config.getAuthorBanner());
        System.out.printf("""
                PROGRAM: %s
                Date Created: %s
                Created by: %s
                """,
                config.getProgramName(),
                config.getDateCreated(),
                config.getAuthorName());
    }

    public void printConclusion() {
        System.out.printf("""
                %s
                Thank you for using the program!!
                - %s
                """,
                config.getProgramName(),
                config.getDateCreated(),
                config.getAuthorName());
    }
    public void printOptions(String[] options){
        for(int i=1;i<options.length;i++)
            System.out.printf("%n[%d] %s", i, options[i]);
        System.out.printf("%n[%d] %s", 0, options[0]);
    }

    public void printBanner(String s){
        printBorder(s.length() + 18);
        System.out.printf("%n{| %-6s%s%6s |}", "", s, "");
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
