
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Simulatore di inquinamento");
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        try {
            pos = new PipedOutputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        int soglia = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Inserire soglia critica: ");
            try{
                soglia = Integer.parseInt(br.readLine());
                
            }catch(IOException e){
                e.printStackTrace();
            }catch(NumberFormatException nfe){
                System.out.println("La soglia deve essere un numero");
                continue;
            }
            if(soglia>=100&&soglia<=200)
                break;
            else
                System.out.println("Soglia deve essere un intero compreso tra 100 e 200");
        }
        GeneraRilevazione gr = new GeneraRilevazione(pos);
        gr.start();
        
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        int count = 0;
        int countW = 0;
        Rilevazione r = null;
        while(count<10){
            try{
                r =(Rilevazione) ois.readObject();
            }catch(IOException | ClassNotFoundException ioe){
                ioe.printStackTrace();
            }
            if(r.getValore()<=50)
                System.out.println("Basso: "+r.getValore());
            else if(r.getValore()<100)
                System.out.println("Moderato: "+r.getValore());
            else
                System.out.println("Alto: "+r.getValore());

            if(r.getValore()>soglia)
                countW++;
            else
                countW=0;

            if(soglia==3)
                System.out.println("Warning, soglia = 3");

            count++;
        }
        gr.terminaRilevazioni();

        //attendo la fine del thread
        try {
            gr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulazione terminata");
    }
}
