package es4;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Esercizio4 {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        System.out.println("Esercizio4");

        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        try {
            pos = new PipedOutputStream(pis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimulaSensore simulaSensore = new SimulaSensore(pos);
        Thread t1 = new Thread(simulaSensore);
        t1.start();

        MonitoraSerra monitoraSerra = new MonitoraSerra(pis);
        Thread t2 = new Thread(monitoraSerra);
        t2.start();

        try {
            Thread.sleep(5000); // dovrebbe essere 90000
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        simulaSensore.termina();
        t1.interrupt();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fine");
    }
}