
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public static void main(String[] args) throws Exception {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        try {
            pos = new PipedOutputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Machine m = new Machine(pos);
        m.start();

        Overall overall = new Overall();
        Quality q = new Quality(pis, overall);

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(overall.getDifetti()>overall.getCorretti()){
                m.fermaMachine();
                q.fermaQuality();
                break;
            }
        }
        try {
            m.join();
            q.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
