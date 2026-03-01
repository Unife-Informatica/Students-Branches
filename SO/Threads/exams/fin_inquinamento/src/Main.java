
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main{
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Inquinamento");
        
        PipedOutputStream pos = null;
        PipedInputStream pis = new PipedInputStream();
        Rilevazione r;
        int soglia = 0;
        int cont = 0;
        int contS = 0;
        try {
            pos = new PipedOutputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(pis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        GeneraRilevazioni gr = new GeneraRilevazioni(pos);
        gr.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserire valore di soglia critica");
        try {
            soglia = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(cont<10){
            r=(Rilevazione)ois.readObject();
            if(r.getValore()<=50)
                System.out.println("Basso: "+r.getValore());
            else if(r.getValore()<100)
                System.out.println("Moderato: "+r.getValore());
            else
                System.out.println("Alto");
            if(soglia>r.getValore())
                contS++;
            else
                cont = 0;
            cont++;
        }
    }
}
