package es1.buffered;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PipedInputStream;

public class Actuator extends Thread {

    private PipedInputStream pis;
    private float targetTemperature;

    public Actuator(PipedInputStream pis, float temperature) {
        this.pis = pis;
        this.targetTemperature = temperature;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(pis);
            while (true) {

                float temperature = dis.readFloat();
                System.out.println("temperature: " + temperature);
                if (temperature < targetTemperature) {
                    System.out.println("*** Accendere il riscaldamento, temperatura corrente: " +
                            temperature + "***");
                }
            }
        } catch (IOException e) {
            System.err.println("Actuator: error when reading from Sensor");
            e.printStackTrace();
        }
    }

}