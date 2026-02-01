import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {

    public static void main() {
        PipedInputStream pis = new PipedInputStream(); // crea lo stream di lettura
        PipedOutputStream pos = null; // crea lo stream di scrittura
        ObjectOutputStream oos = null; // legge l'oggetto ricevuto tramite il canale di comunicazione pos
        ObjectInputStream ois = null; // scrive l'oggetto ricevuto tramite il canale di comunicazione pis

        try {
            pos = new PipedOutputStream(pis);

            oos = new ObjectOutputStream(pos);
            oos.flush();

            ois = new ObjectInputStream(pis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sender sender = new Sender(oos);
        Viewer viewer = new Viewer(ois);

        viewer.start();
        sender.start();

        try {
            viewer.join(); // fa attendere al main thread la fine del thread
            sender.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
