package es4;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.nio.charset.Charset;

public class SimulaSensore implements Runnable {

    private PipedOutputStream pos = null;
    final private AtomicBoolean isRunning = new AtomicBoolean(false);

    public SimulaSensore(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        isRunning.set(true);
        while (isRunning.get()) {
            try {
                int temperatura = (int) (Math.random() * 51) - 10;
                String temperaturaStr = "" + temperatura;
                byte[] bytes = temperaturaStr.getBytes(Charset.forName("UTF-8"));
                pos.write(bytes, 0, bytes.length);
                pos.flush();
                System.out.println("valore rilevato: " + temperatura);

                Thread.sleep(3000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                System.out.println("SimulaSensore: sleep interrupted");
            }
        }
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void termina() {
        isRunning.set(false);
        try {
            pos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}