import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class StatLineWriterDecorator extends LineWriterDecorator{

    public StatLineWriterDecorator( LineWriter lw, Copy c) {
        super(lw, c);
    }

    @Override
    public void printAllLines(List storage) {
        lineWriter.printAllLines(storage);

        makeStatistics(storage);
    }

    public void makeStatistics(List storage){
        int tot = 0;
        Iterator i = storage.iterator();
        while(i.hasNext()){
            tot+= i.next().toString().length();
        }
        out.println("Totale caratteri: " + tot);
    }

    @Override
    public void update(Object o) {
            printAllLines((List) o );
    }
    @Override
    public void update(Subject s) {
        Copy c = (Copy) s;
        printAllLines(c.getStorage());
    }
}
