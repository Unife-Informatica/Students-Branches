import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main(String[] args) {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        ObjectInputStream ois = null;

        try {
            pos = new PipedOutputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RilevatoreAria r = new RilevatoreAria(pos);

        r.start();

        try {
            BufferedInputStream bis = new BufferedInputStream(pis);
            ois = new ObjectInputStream(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                Rilevazione ri = (Rilevazione) ois.readObject();
                System.out.println("Valore: " + ri.getVal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            r.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
