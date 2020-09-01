import java.io.*;
import java.util.*;

public class LineReader {

    private BufferedReader reader;

    public LineReader(String filename){
        try{
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {e.printStackTrace(); }


    }

    public void readAllLine(List storage){
        try{
            String line = reader.readLine();
            while(line != null){
                storage.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
