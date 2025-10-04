package ui.console;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleReader{
    private BufferedReader reader;

    public ConsoleReader(BufferedReader reader){
        this.reader = reader;
    }

    public boolean readBoolean() throws IllegalArgumentException{
        return switch(readLine().trim().toLowerCase()){
            case "yes", "y","true", "t", "1" -> true;
            case "no", "n","false", "f", "0" -> false;
            default -> throw new IllegalArgumentException("Invalid boolean input. Must be (y/n)");
        };
    }

    public int readInt() throws IllegalArgumentException{
        try{
            return Integer.parseInt(readLine());
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("Invalid integer. Please try again");
        }
    }

    public  int readIntWithRange(int min, int max){
        int num = readInt();
        if(num >= min && num <= max)
            return num;
        throw new IllegalArgumentException(String.format("Invalid input. Must be %d-%d", min, max));
    }

    public String readString() throws IllegalArgumentException{
        String str = readLine();
        if(str.isEmpty() || str.isBlank() || str == null)
            throw new IllegalArgumentException("Invalid input. Please try again");
        return str;
    }

    public void close(){
        try{
            reader.close();
        }catch(IOException ignored){}
    }

    private String readLine(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid input. Please try again");
        }
    }
}
