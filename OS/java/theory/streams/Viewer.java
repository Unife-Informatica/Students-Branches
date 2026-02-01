import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Viewer extends Thread {

    private InputStream in = null;

    public Viewer(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(in))
        ) {
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("[Messaggio]: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
