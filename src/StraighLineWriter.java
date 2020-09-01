import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

public class StraighLineWriter extends LineWriter {

    public StraighLineWriter(ConversionStrategy fConverter, Copy c) {
        this.out = c.getOut();
        this.fConverter = fConverter;
        this.copy = c;
    }

    @Override
    public void printAllLines(List storage) {
        Iterator i = storage.iterator();

        while (i.hasNext()) {
            String line = i.next().toString();
            out.println(fConverter.convert(line));
        }
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
