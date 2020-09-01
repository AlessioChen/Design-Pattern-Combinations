import java.io.*;
import java.util.*;

abstract class LineWriter implements Observer {

    protected PrintStream out;
    protected ConversionStrategy fConverter;
    protected  Copy copy;

    public abstract  void printAllLines(List storage);

    public void setfConverter(ConversionStrategy strategy){
        this.fConverter = strategy;
    }

}
