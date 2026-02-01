import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Sender extends Thread {

    private final ObjectOutputStream oos;

    public Sender(ObjectOutputStream oos) {
        this.oos = oos;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Scrivi un messaggio: ");
                String text = sc.nextLine();
                Message msg = new Message(text);

                oos.writeObject(msg);
                oos.flush();

                if ("fine".equalsIgnoreCase(text)) {
                    break;
                }
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
