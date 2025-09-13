package app;

/**
 * Tag system for better logging of console outputs
 */
enum ConsoleTag{
    GAME("[GAME]"),
    ERROR("[ERROR]"),
    INFO("[INFO]"),
    DEBUG("[DEBUG]"),
    SYSTEM("[SYSTEM]");

    // Field for Console Tag labels
    private String tag;

    // Enum constructor
    ConsoleTag(String tag){this.tag = tag;}

    // Returns the string field for the constant used
    String label(){return tag;}

}
