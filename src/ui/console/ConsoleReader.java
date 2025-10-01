package ui.console;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader {
    private BufferedReader reader;

    public ConsoleReader(BufferedReader reader){
        this.reader = reader;
    }

    /**
     * Gets boolean based on appropriate inputs
     * @return true / false
     */
    public boolean readBoolean() throws IllegalArgumentException{
        String input = readString();

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
        throw new IllegalArgumentException("Invalid boolean input. Must be (y/n)");
    }

    /** @return a valid integer */
    public int readInt() throws IllegalArgumentException{
        try{
            return Integer.parseInt(reader.readLine());
        }catch(IOException | NumberFormatException e){
            throw new IllegalArgumentException("Invalid integer. Please try again");
        }
    }

    /** @return a valid integer from range min-max inclusive */
    public  int readIntWithRange(int min, int max){
        int num = readInt();
        if(num >= min && num <= max)
            return num;
        throw new IllegalArgumentException(String.format("Invalid input. Must be %d-%d", min, max));
    }

    /** @return a valid String value */
    public String readString(){
        while(true){
            try{
                return reader.readLine();
            }catch(IOException e){
               throw new IllegalArgumentException("Invalid text. Please try again.");
            }
        }
    }

    /** Closes the buffered reader */
    public void close(){
        try{
            reader.close();
        }catch(IOException ignored){}
    }
}
