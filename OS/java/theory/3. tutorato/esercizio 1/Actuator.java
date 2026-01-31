import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Actuator extends Thread {

    private InputStream inputStream;

    public Actuator(InputStream in) {
        inputStream = in;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[Double.BYTES];

        try {
            while (inputStream.read(buffer) == Double.BYTES) {
                double val = ByteBuffer.wrap(buffer).getDouble();

                if (val >= 19.5) {
                    System.out.printf(
                        "Accendi il riscaldamento. Temperatura = %.2f\n",
                        val
                    );
                } else {
                    System.out.printf(
                        "Spegni il riscaldamento. Temperatura = %.2f\n",
                        val
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
