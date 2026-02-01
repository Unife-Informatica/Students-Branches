import java.io.ObjectInputStream;

public class Viewer extends Thread {

    private final ObjectInputStream ois;

    public Viewer(ObjectInputStream ois) {
        this.ois = ois;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = (Message) ois.readObject();

                if (msg == null) {
                    break;
                }

                System.out.println("[Message]: " + msg.getMessage());

                if ("fine".equalsIgnoreCase(msg.getMessage())) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Viewer terminato");
        }
    }
}
