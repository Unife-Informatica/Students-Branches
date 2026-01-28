
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class App {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Esercizio1Stream");
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = null;
        try{
            pos=new PipedOutputStream(pis);
        }catch(IOException ioe){
            System.out.println("Impossibile creare PipedOutputStream");
            System.exit(-3);
        }
        MacchinaA mA = new MacchinaA(pos);
        Thread tmA = new Thread(mA);
        tmA.start();

        MacchinaB mB=new MacchinaB(pis);
        Thread tmB = new Thread(mB);
        tmB.start();

        try{
            Thread.sleep(60*1000);
            mA.stopMacchinaA();
            tmA.interrupt();
            mB.stopMacchinaB();
            tmB.interrupt();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        try {
            tmA.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException when joining threads");
            e.printStackTrace();
        }

        try {
            tmB.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException when joining threads");
            e.printStackTrace();
        }

        System.out.println("Esercizio1Stream fine");
    }
}
