import java.io.*;

public class Main {

    public static void main() {
        try {
            PipedOutputStream pipeOut = new PipedOutputStream();
            PipedInputStream pipeIn = new PipedInputStream();

            pipeOut.connect(pipeIn);

            Actuator actuator = new Actuator(pipeIn);
            Sensor sensor = new Sensor(pipeOut);

            sensor.start();
            actuator.start();
        } catch (IOException e) {}
    }
}
