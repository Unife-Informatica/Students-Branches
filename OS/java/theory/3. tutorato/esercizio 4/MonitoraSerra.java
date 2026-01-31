
import java.io.IOException;
import java.io.InputStream;

public class MonitoraSerra implements Runnable{

    InputStream inputStream;

    public MonitoraSerra(InputStream in) {
        inputStream = in;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int bufferLenght;

        try {
            while ((bufferLenght = inputStream.read(buffer)) != -1) {
                String mess = new String(buffer, 0, bufferLenght);
                System.out.println("Valore: " + mess);
                double val = Double.parseDouble(mess);
                if(val > 35 || val < 5) {
                    System.out.println("[Warning]: la temperatura è fuori range");
                }
            }
        } catch(IOException e) {
            
        }
    }
}
