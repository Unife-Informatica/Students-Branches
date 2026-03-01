
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("WebServer");
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        try {
            pos = new PipedOutputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        VerificaInput vi = new VerificaInput();
        InputUtente iu = new InputUtente(pos);
        Thread tiu = new Thread(iu);
        tiu.start();

        ScansionaInput sc = new ScansionaInput(pis,vi);
        Thread tsc = new Thread(sc);
        tsc.start();

        while(true){
            try {
            Thread.sleep(200);
            if(vi.getNumeroStringheSospette()>3){
                iu.fermaInputUtente();
                sc.fermaScansionaInput();
                break;
            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            tiu.join();
            tsc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
