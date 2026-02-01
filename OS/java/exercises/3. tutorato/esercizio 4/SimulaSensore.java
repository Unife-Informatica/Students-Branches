
import java.io.IOException;
import java.io.OutputStream;

public class SimulaSensore implements Runnable {

    OutputStream outputStream;

    public SimulaSensore(OutputStream out) {
        outputStream = out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                double val = Math.random() * 50 - 10;
                String cnv = val + "";
                byte[] mess = cnv.getBytes();
                outputStream.write(mess);
                outputStream.flush();
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
        }
    }
}
