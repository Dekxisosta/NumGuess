package app;

/* =======================================================
 *          NUMBER GUESSING PROGRAM
 * ====================================================== */

import bootstrap.*;

public class Main {
    public static void main(String[] args) {
        try{
            new ProgramRunner(new Bootstrap().init()).run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
