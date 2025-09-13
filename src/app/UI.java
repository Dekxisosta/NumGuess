package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UI {
    /** Object for reading console input */
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /** Constructor */
    UI(){};

    /*======================================================
     *          PROGRAM UI METHODS
     *======================================================*/

    /**
     * Shows options in the console
     * @param options String values used to display menu of options
     */
     void showOptions(String[] options){
         // Prints options in console
        for(int i=1;i<options.length;i++)
            printf("%n[%d] %s", i, options[i]);

        //Reserved for program termination
        printf("%n[%d] %s", 0, options[0]);
     }

    /**
     * Show banner based on text passed
     * @param s the text of the banner
     */
     void showBanner(String s){
        printBorder(s.length() + 6);
        printf("%n{| %s |}", s);
        printBorder(s.length() + 6);
     }

    /**
     * Shows an enter prompt
     */
     void showEnterPrompt(){
         printf("%nEnter: ");
     }

    /**
     * Shows an enter prompt with a display of input type
     * @param inputType type of input asked
     */
     void showEnterPrompt(String inputType){
         printf("%nEnter %s: ", inputType);
     }

    /**
     * Shows a border for banner
     * @param length
     */
     void printBorder(int length){
         printf("%n%s", "=".repeat(length));
     }




    /*======================================================
     *          CONSOLE READING METHODS
     *======================================================*/
    /**
     * Gets boolean based on appropriate inputs
     * @return true / false
     */
    boolean getBoolean(){
        while(true){
            String input = getString();

            if(input.equalsIgnoreCase("yes")
                    || input.equalsIgnoreCase("y")
                    || input.equalsIgnoreCase("true")
                    || input.equalsIgnoreCase("t")
                    || input.equalsIgnoreCase("1")
            ) return true;

            if(input.equalsIgnoreCase("no")
                    || input.equalsIgnoreCase("n")
                    || input.equalsIgnoreCase("false")
                    || input.equalsIgnoreCase("f")
                    || input.equalsIgnoreCase("0")
            ) return false;

            showMessage(ConsoleTag.ERROR, "Invalid input. Please try again (y/n)");
        }
    }

    /** @return a valid integer */
    int getInt(){
        while(true){
            try{
                return Integer.parseInt(br.readLine());
            }catch(IOException | NumberFormatException e){
                showMessage(ConsoleTag.ERROR, " Invalid integer. Please try again");
            }
        }
    }

    /** @return a valid integer from range min-max inclusive */
    int getIntWithRange(int min, int max){
        while(true){
            int num = getInt();
            if(num >= min && num <= max)
                return num;
            showMessage(ConsoleTag.ERROR, " Invalid integer, must be (%d - %d). Please try again", min, max);
        }
    }

    /** @return a valid String value */
    String getString(){
        while(true){
            try{
                return br.readLine();
            }catch(IOException e){
                showMessage(ConsoleTag.ERROR, " Invalid text. Please try again");
            }
        }
    }

    /*======================================================
     *          CONSOLE OUTPUT UTILITY METHODS
     *======================================================*/

    /**
     * Shows an appropriate tag for a message to be displayed
     * @param tag
     * @param format
     * @param args
     */
    void showMessage(ConsoleTag tag, String format, Object... args){
        printf("%n%s ", tag.label());
        printf(format, args);
    }

    /** Shorthand printf method */
    void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    /** Shorthand println method */
    void println(){
        System.out.println();
    }
}
