package common.util;

import config.AppConfig;

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

    Ansi(String code){
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    public String wrap(String text){
        return (config.isANSISupported()) ? code + text + RESET: text;
    }
}