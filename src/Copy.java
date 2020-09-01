import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Copy extends Subject {

    private List storage;
    private PrintStream out;
    private String inputFile;

    private List<Observer> observers;

    public Copy(String inputFile, PrintStream out) {
        storage = new ArrayList();
        this.out = out;
        this.inputFile = inputFile;

        //legge le righe di un file
        LineReader in = new LineReader(inputFile);
        in.readAllLine(storage);

        //instanzio la lista deli Observer
        observers = new ArrayList();
    }

    public void toOutput(LineWriter out) {
        out.printAllLines(storage);
    }

    public PrintStream getOut() {
        return this.out;
    }

    public void setInputFile(String filename) {
        this.inputFile = filename;
        //update a tutti gli observers
        storage = new ArrayList();
        LineReader in = new LineReader(this.inputFile);
        in.readAllLine(storage);
        this.notifyAllObservers();


    }


    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);

    }

    @Override
    public void notifyAllObservers() {

        for (Observer o : this.observers) {
            o.update(this.storage); //push
            //o.update(this); //pull
        }

    }

    public List getStorage() {
        return this.storage;
    }
}
