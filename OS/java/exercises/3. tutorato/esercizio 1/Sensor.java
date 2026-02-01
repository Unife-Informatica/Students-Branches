import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class Sensor extends Thread {

    private OutputStream outputStream;

    public Sensor(OutputStream out) {
        outputStream = out;
    }

    @Override
    public void run() {
        while (true) {
            // random * (max - min) + min
            double val = Math.random() * (21 - 18) + 18;
            System.out.println(val);

            byte[] mess = ByteBuffer.allocate(Double.BYTES)
                .putDouble(val)
                .array();

            try {
                outputStream.write(mess);
                outputStream.flush();
            } catch (IOException e) {
                System.err.println("[Errore]: errore durante l'invio del dato");
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.err.println("[Errore]: Interruzione durante il sonno");
            }
        }
    }
}
