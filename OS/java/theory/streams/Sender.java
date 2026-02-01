import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Sender extends Thread {

    private OutputStream out;

    public Sender(OutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Inserisci il messaggio: ");
                String msg = sc.nextLine();

                if (msg.equalsIgnoreCase("fine")) {
                    break;
                }

                byte[] data = msg.getBytes();

                out.write(data);
                out.flush();
                Thread.sleep(10);
            }
            sc.close();
            out.close(); // chiude la pipe in modo che si fermi anche il viewer
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
