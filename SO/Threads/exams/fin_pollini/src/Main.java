
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Pollini");
        PipedOutputStream pos = null;
        PipedInputStream pis = new PipedInputStream();
        try {
            pos = new PipedOutputStream(pis);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        RilevatoreAria ra = new RilevatoreAria(pos);
        ra.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(pis));
        int valore=0;
        long oldTime = 0;
        long currTime = 0;
        for(int i = 0;i<8;i++){
            try {
               valore = Integer.parseInt(br.readLine());
               currTime = Long.parseLong(br.readLine()); 
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
            if(valore < 20)
                System.out.println("Basso: "+valore);
            else if(valore <=75)
                System.out.println("Medio: "+valore);
            else 
                System.out.println("Alto: "+valore);

            long newTime = currTime - oldTime;
            if(newTime>15&&oldTime!=0){
                System.out.println("Attenzione"+newTime);
            }
            oldTime=currTime;
            
        }
        ra.fermaRilevatoreAria();

        try {
            ra.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

    }
    
}


