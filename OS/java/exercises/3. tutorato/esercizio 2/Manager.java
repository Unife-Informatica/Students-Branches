import java.io.IOException;
import java.io.InputStream;

public class Manager extends Thread {

    InputStream inputStream;
    int count = 0;

    public Manager(InputStream out) {
        inputStream = out;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        int byteLength;

        try {
            while (
                (byteLength = inputStream.read(buffer)) != -1 || count >= 10
            ) {
                String mess = new String(buffer, 0, byteLength);
                count++;

                System.out.println(mess);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
