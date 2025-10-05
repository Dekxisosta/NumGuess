package common.logging;

import common.util.*;
import config.AppConfig;
/* ========================================
 *        CONSOLE LOG ENUM
 ==========================================*/
/**
 *
 * Logger class for distinction of
 * DEPENDENCIES:
 * {@link Ansi} for colored logs
 * </p>
 */
public enum Logger {
    DEBUG(Ansi.BRIGHT_CYAN.toString()),
    ERROR(Ansi.BRIGHT_RED.toString()),
    SYSTEM(Ansi.BRIGHT_YELLOW.toString()),
    INFO(Ansi.BRIGHT_GREEN.toString());

    private AppConfig config = AppConfig.getInstance();
    private final boolean IS_ANSI_SUPPORTED = config.isANSISupported();
    private final String code;

    Logger(String code) {
        this.code = code;
    }

    public String label() {
        if (IS_ANSI_SUPPORTED) return "" + Ansi.BOLD + Ansi.REVERSE + this.code + " " + this.name() + " " + Ansi.RESET;
        else return "[" + this.name() + "]";
    }

    public String label(String label) {
        if (IS_ANSI_SUPPORTED) return "" + Ansi.BOLD + Ansi.REVERSE + Ansi.BRIGHT_WHITE + " " + label + " " + Ansi.RESET;
        else return "[" + label + "]";
    }
}


