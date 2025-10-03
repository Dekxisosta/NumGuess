package common.util;

import config.AppConfig;

/**
 * Utility class for colored console outputs
 * for better readability and formatting
 */
public enum Ansi {
    RESET("\u001B[0m"),
    BOLD("\u001B[1m"),
    REVERSE("\u001B[7m"),
    WHITE("\u001B[37m"),
    BRIGHT_RED("\u001B[91m"),
    BRIGHT_GREEN("\u001B[92m"),
    BRIGHT_YELLOW("\u001B[93m"),
    BRIGHT_CYAN("\u001B[96m"),
    BRIGHT_WHITE("\u001B[97m");

    private AppConfig config = AppConfig.getInstance();
    private String code;

    /**
     * Ansi class constructor
     * @param code ansiCode for the corresponding constant's color
     */
    Ansi(String code){
        this.code = code;
    }

    /** @return ansiCode on Ansi class constant call*/
    @Override
    public String toString() {
        return code;
    }
    /**
     * Wraps text with corresponding constant's code. Auto reset
     * @param text the text to be wrapped
     */
    public String wrap(String text){
        return (config.isANSISupported()) ? code + text + RESET: text;
    }
}