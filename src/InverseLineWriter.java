import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class InverseLineWriter extends LineWriter{
    public InverseLineWriter( ConversionStrategy fConverter, Copy c) {
      this.out = c.getOut();
      this.fConverter = fConverter;
      this.copy = c;
    }

    @Override
    public void printAllLines(List storage) {
        Iterator i = storage.iterator();

        Vector v = new Vector();
        while(i.hasNext()){
            String line = i.next().toString();
            v.addElement(fConverter.convert(line));
        }

        for(int j= v.size()-1; j>=0; j--){
            out.println(v.elementAt(j));
        }


    }

    @Override
    public void update(Object o) {
            this.printAllLines((List) o );
    }
    @Override
    public void update(Subject s) {
        Copy c = (Copy) s;
        printAllLines(c.getStorage());
    }
}
