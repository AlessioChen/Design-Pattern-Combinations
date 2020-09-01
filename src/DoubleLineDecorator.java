import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoubleLineDecorator extends LineWriterDecorator {

    public DoubleLineDecorator(LineWriter lw, Copy c) {
        super(lw, c);
    }


    @Override
    public void printAllLines(List storage) {

        List r = doubleLines(storage);
        lineWriter.printAllLines(r);

    }

    public List doubleLines(List storage) {
        List result = new ArrayList();
        Iterator i = storage.iterator();

        while (i.hasNext()) {
            String s = (String) i.next();
            result.add(s);
            result.add(s);

        }

        return result;
    }

    @Override
    public void update(Object o) {
        printAllLines((List) o);

    }

    @Override
    public void update(Subject s) {
        Copy c = (Copy) s;
        printAllLines(c.getStorage());
    }


}
