
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        PipedOutputStream pos = null;
        PipedInputStream pis = new PipedInputStream();
        try {
            pos = new PipedOutputStream(pis);
            BufferedReader br = new BufferedReader(new InputStreamReader(pis));
            RilevatoreAria ra = new RilevatoreAria(pos);
            ra.start();

            long oldtime = 0;
            for(int i=0;i<8;i++){
                int valore = Integer.parseInt(br.readLine());
                long timestamp = Long.parseLong(br.readLine());
                if(valore<20)
                    System.out.println("Basso: "+valore);
                else if(valore<=75)
                    System.out.println("Medio: "+valore);
                else
                    System.out.println("Alto: "+valore);

                long actuale = timestamp - oldtime;
                if(actuale>15&&oldtime!=0)
                    System.out.println("Attenzione valore altooo");

                oldtime=actuale;
            }
            ra.fermaRilevatoreAria();
            try {
                ra.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
