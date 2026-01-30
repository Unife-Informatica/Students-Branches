package es1.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;

public class Actuator extends Thread {

    private PipedInputStream pis;
    private float targetTemperature;

    public Actuator(PipedInputStream pis, float temperature) {
        this.pis = pis;
        this.targetTemperature = temperature;
    }

    public void run() {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(pis);
        } catch (IOException e) {
            System.err.println("Impossible to create an ObjectInputStream from the given PipedInputStream!");
            e.printStackTrace();
            System.exit(-2);
        }

        try {
            while (true) {
                Message tempMessage = (Message) ois.readObject();
                if (tempMessage == null)
                    break;
                float temperature = tempMessage.getTemperature();
                System.out.println("temperature: " + temperature);
                if (temperature < targetTemperature) {
                    System.out.println("*** Accendere il riscaldamento, temperatura corrente: " +
                            temperature + "***");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Actuator: error when reading from Sensor");
            e.printStackTrace();
        }
    }

}