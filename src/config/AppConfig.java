package config;

import common.util.*;

/**
 * Singleton Application-level configuration class.
 */
public class AppConfig {
    private static String PROGRAM_NAME;
    private static String AUTHOR_NAME;
    private static String AUTHOR_BANNER;
    private static String DATE_CREATED;
    private static boolean IS_ANSI_SUPPORTED;
    private static String HEADER_COLOR;

    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {
        PROGRAM_NAME = "Java Coursework Linked List Template";
        AUTHOR_NAME = "Dekxi";
        IS_ANSI_SUPPORTED = true;
        AUTHOR_BANNER = """
                 _____         __           __
                |     \\.-----.|  |--.--.--.|__|   || UI DESIGNER          |
                |  --  |  -__||    <|_   _||  |   || PROGRAMMER           |
                |_____/|_____||__|__|__.__||__|   || VOCALOID ENTHUSIAST  |
                """;
        DATE_CREATED = "2025 / 09 / 24";
        HEADER_COLOR = "" + Ansi.BRIGHT_WHITE;
    }

    public static AppConfig getInstance() {return INSTANCE;}
    public String getProgramName() {return PROGRAM_NAME;}
    public String getAuthorName() {return AUTHOR_NAME;}
    public boolean isANSISupported() {return IS_ANSI_SUPPORTED;}
    public String getAuthorBanner() {return AUTHOR_BANNER;}
    public String getDateCreated() {return DATE_CREATED;}
    public String getHeaderColor() {return HEADER_COLOR;}
}