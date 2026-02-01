
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main() {
        PipedOutputStream pipedOut = new PipedOutputStream();
        PipedInputStream pipedIn = new PipedInputStream();

        try {
            pipedOut.connect(pipedIn);

            MonitoraSerra monitoraSerra = new MonitoraSerra(pipedIn);
            SimulaSensore simulaSensore = new SimulaSensore(pipedOut);

            Thread threadSerra = new Thread(monitoraSerra);
            Thread threadSensore = new Thread(simulaSensore);

            threadSerra.start();
            threadSensore.start();

            Thread.sleep(90 * 1000);
        } catch (IOException | InterruptedException e) {
        }
    }
}
