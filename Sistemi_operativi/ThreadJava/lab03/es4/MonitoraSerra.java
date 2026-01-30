package es4;

import java.io.IOException;
import java.io.PipedInputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

public class MonitoraSerra implements Runnable {

    private PipedInputStream pis = null;

    public MonitoraSerra(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        byte buffer[] = new byte[1024];
        int nread = 0;
        try {
            while ((nread = pis.read(buffer)) > 0) {
                byte message_buffer[] = Arrays.copyOfRange(buffer, 0, nread);
                String message = new String(message_buffer, Charset.forName("UTF-8"));
                int temperatura = Integer.parseInt(message);
                if (temperatura < 5 || temperatura > 35) {
                    System.out.println("warning: " + temperatura);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}