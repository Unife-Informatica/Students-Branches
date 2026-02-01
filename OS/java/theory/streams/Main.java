import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main(String[] args) {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;

        try {
            pos = new PipedOutputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sender s = new Sender(pos);
        Viewer v = new Viewer(pis);

        s.start();
        v.start();

        try {
            s.join();
            v.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
