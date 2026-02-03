
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("\tSimulazione inquinamento");
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = null;
        try{
            pis = new PipedInputStream(pos);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int soglia = 0;
        while(true){
            System.out.println("Inserire soglia (100>=soglia<=200):");
            try {
                soglia = Integer.parseInt(br.readLine());
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
            if(soglia>=100&&soglia<=200)
                break;
            else
                System.out.println("Errore!: Il valore di soglia deve essere compresto tra 100 e 200");
        }
        GeneraRilevazioni gr = new GeneraRilevazioni(pos);
        gr.start();

        ObjectInputStream ois = null;
        try {
            ois= new ObjectInputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        int count = 0;
        int countW=0;
        Rilevazione r = null;
        while(count<10){
            try {
                r = (Rilevazione) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(r.getValore()<50)
                System.out.println("Basso: "+r.getValore());
            else if(r.getValore()<=100)
                System.out.println("Moderato: "+r.getValore());
            else
                System.out.println("Alto: "+r.getValore());

            if(r.getValore()>soglia){
                countW++;
                System.out.println("Soglia: "+countW);
            }
            else{
                countW=0;
                System.out.println("Soglia: "+countW);
            }

            if(countW==3)
                System.out.println("Warning: l'inquinamento ha superato la soglia per "+countW+" volte di seguito");
            count++;
        }
        
        gr.terminaRilevazioni();

        //attendo gr
        try {
            gr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Termine simulazione inquinamento");
    }
}
