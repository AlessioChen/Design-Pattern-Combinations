import java.io.PrintStream;
import java.util.List;

public abstract class LineWriterDecorator extends  LineWriter{

    protected LineWriter lineWriter;

    public LineWriterDecorator(LineWriter lw, Copy c) {
        this.lineWriter  =lw ;
        this.out = lw.out;
        this.fConverter = lw.fConverter;
        this.copy = c;
    }


    @Override
    public abstract void printAllLines(List storage);

}
