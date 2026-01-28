
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimulaProduzione extends Thread{
    private Macchina macchina = new Macchina();
    private final AtomicBoolean isRunning = new AtomicBoolean(false);

    public SimulaProduzione(Macchina macchina){
        this.macchina=macchina;
    }

    public void stopSimulazione(){
        isRunning.set(false);
    }

    @Override
    public void run(){
        Random random = new Random();
        int pezziProdotti = macchina.getPezziProdotti();

        isRunning.set(true);

        while(isRunning.get()){
            int pezziProdottiNow = random.nextInt(10);
            pezziProdotti+=pezziProdottiNow;
            macchina.setPezziProdotti(pezziProdotti);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("SimulaProduzione: sleep interrupted");
            }
        }
        
    }
}
