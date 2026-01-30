package es2;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Esercizio2 {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        System.out.println("Esercizio2");

        ThreadLoad tl = new ThreadLoad();

        // Monitor implementa Runnable per definire il metodo stop
        Monitor monitor = new Monitor(tl);
        Thread tmonitor = new Thread(monitor);

        PipedInputStream pip = new PipedInputStream();
        try {
            PipedOutputStream pop = new PipedOutputStream(pip);

            // Sorter implementa Runnable
            Sorter sorter = new Sorter(tl, pop);
            Thread tsorter = new Thread(sorter);

            // Manager estende Thread
            Manager manager = new Manager(monitor, sorter, pip);

            tmonitor.start();
            tsorter.start();
            manager.start();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Impossible to create a piped stream");
            System.exit(-1);
        }

    }

}
