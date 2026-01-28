
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Pollini");

        PipedOutputStream pos = new PipedOutputStream();
        try {
            PipedInputStream pis = new PipedInputStream(pos);
            BufferedReader bf = new BufferedReader(new InputStreamReader(pis));
            RilevatoreAria ra = new RilevatoreAria(pos);
            ra.start();

            long oldTime = 0;
            for(int i=0;i<4;i++){
                int val = Integer.parseInt(bf.readLine());
                long newTime = Long.parseLong(bf.readLine());

                if(val<20)
                    System.out.println("Basso - "+val);
                else if(val<=75)
                    System.out.println("Medio - "+val);
                else
                    System.out.println("Alto - "+val);

                long time = newTime - oldTime;
                if(time>15&&oldTime!=0){
                    System.out.println("Attenzione: "+time);
                }
                oldTime=newTime;
            }
            ra.stopRilevatoreAria();
            try {
                ra.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("llll");
            }
            System.out.println("Esercizio terminato");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
