package ui;

import common.logging.*;

public interface UI {
    void showIntroduction();
    void showConclusion();
    int showMenuAndGetChoice(String title, String[] options);
    void showOptions(String[] options);
    void showBanner(String title);
    void showEnterPrompt();
    void showBorder(int length);
    void showMessage(String text, Logger type);
    void showLineBreak();

    boolean getBoolean();
    int getInt();
    int getIntWithRange(int min, int max);
    String getString();

    void close();
}
