
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        PipedOutputStream pos = new PipedOutputStream();
        try {
            PipedInputStream pis = new PipedInputStream(pos);
            BufferedReader br = new BufferedReader(new InputStreamReader(pis));
            RilevatoreAria ra = new RilevatoreAria(pos);
            ra.start();

            long timeOld=0;
            for(int i=0;i<4;i++){
                int val = Integer.parseInt(br.readLine());
                long newTime = Long.parseLong(br.readLine());

                if(val<20)
                    System.out.println("Basso - "+val);
                else if(val<=75)
                    System.out.println("Medio - "+val);
                else
                    System.out.println("Alto - "+val);

                long now = newTime - timeOld;
                if(now > 15 && timeOld!=0)
                    System.out.println("Attenzione: "+now);
                timeOld=newTime;
            }
            ra.stopRilevatoreAria();
            ra.interrupt();
            try {
                ra.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
