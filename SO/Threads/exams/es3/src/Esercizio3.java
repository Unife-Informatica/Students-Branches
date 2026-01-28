
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Esercizio3 {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Esercizio3");

        //Richiesta all'utente dell'ID della macchina e l'obbiettivo di produzione
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Inserire l'ID della macchina da monitorare: ");
        String macchinaID = null;
        try{
            macchinaID = stdin.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Inserire l'obiettivo di produzione: ");
        String obbiettivo = null;
        try{
            obbiettivo=stdin.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }

        Macchina macchina = new Macchina();
        macchina.setMacchinaId(Integer.parseInt(macchinaID));

        macchina.setPezziProdotti(0);

        SimulaProduzione sp = new SimulaProduzione(macchina);
        sp.start();

        for(int i=0;i<10;i++){
            try {
                Thread.currentThread().sleep(10000);
                System.out.println("Pezzi totali prodotti dalla macchina: "+macchina.getPezziProdotti());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(macchina.getPezziProdotti()>=Integer.parseInt(obbiettivo))
                System.out.println("Obbiettivo raggiunto");
            else
                System.out.println("Obbiettivo non raggiunto");
        }

        //termino
        sp.stopSimulazione();
        sp.interrupt();

        //attendo la terminazione del thread
        try {
            sp.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Es3 fine");
    }
}
