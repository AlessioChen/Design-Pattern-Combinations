import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            String outputFile = "output.txt";
            Copy copy = new Copy("testo.txt", System.out);
            ConversionStrategy strategy1 = new UpperCaseConverter();
            ConversionStrategy strategy2 = new LowerCaseConverter();
            LineWriter lw = new StraighLineWriter( strategy1, copy);
            StatLineWriterDecorator lws = new StatLineWriterDecorator(lw, copy);
            //output sulla console

            System.out.println("----------------output senza decoratore-------------------");
            copy.toOutput(lw);
            System.out.println("----------------output con aggiunta del decoratore sulle statistiche-------------------");
            copy.toOutput(lws);
            System.out.println("----------------output con aggiunta del decoratore che raddoppia le righe-------------------");
            copy.toOutput(new DoubleLineDecorator(lw, copy));


            //output su un file
            PrintStream outputStream = new PrintStream(outputFile);
            Copy copyIntoFile = new Copy("testo.txt", outputStream);
            LineWriter lw2 = new InverseLineWriter(strategy2, copyIntoFile);
            outputStream.println("--------------output senza decoratore----------------");
            copyIntoFile.toOutput(lw2);
            outputStream.println("--------------output con aggiunta del decoratore sulle statistiche");
            copyIntoFile.toOutput(new StatLineWriterDecorator(lw2, copyIntoFile));


            copy.addObserver(lw);
            copy.addObserver(lw2);
            copy.addObserver(lws);

            System.out.println("------update file 1--------");
            copy.setInputFile("testo2.txt");
            System.out.println("------update file 2--------");
            copy.setInputFile("testo3.txt");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
