
import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class MacchinaB implements Runnable{
    private PipedOutputStream pos = null;
    private ControlloProduzione cp=null;
    //Contatore interno per prodotti finiti
    private int lavoratiFiniti=0;
    public MacchinaB(ControlloProduzione cp, PipedOutputStream pos){
        this.cp=cp;
        this.pos=pos;
    }

    final AtomicBoolean isRunning = new AtomicBoolean(false);
    public void stopMacchinaB(){
        isRunning.set(false);
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void run(){
        isRunning.set(true);

        while(isRunning.get()){
            int semiLavoratiDis = cp.getSemiLavorati();
            if(semiLavoratiDis>0){
                //decremento numero di semilavorati disponibili
                cp.decreaseSemilavorati();
                
                try {
                    int sleepTime=(int)(100+Math.random()*50);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lavoratiFiniti++;
                cp.increaseFiniti();

                System.out.println("Fine lavorazione prodotto finale, lavori finiti: "+lavoratiFiniti);

                String msg="prodottoFinito";
                try {
                    pos.write(msg.getBytes("UTF-8"));
                    pos.flush();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("MacchinaB: semiLavorati non sufficienti per avviare la produzione");
                try {
                    Thread.sleep(2000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
