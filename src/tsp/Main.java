package tsp;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Tsp tsp = new Tsp();

        tsp.readFile();
        tsp.calculate(0);


    }
}
