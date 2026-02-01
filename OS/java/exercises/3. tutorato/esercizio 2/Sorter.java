import java.io.IOException;
import java.io.OutputStream;

public class Sorter extends Thread {

    OutputStream outputStream;

    public Sorter(OutputStream in) {
        outputStream = in;
    }

    public void run() {
        try {
            while (true) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
