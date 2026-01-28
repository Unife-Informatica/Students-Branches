

public class Esercizio1Extends {
    //numero massimo di thread possibili
    final static int N=25;
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        System.out.println("Esercizio1Extends");

        Accumulatore acc = new Accumulatore(1.0);

        CounterThreds ct[] = new CounterThreds[N];
        for (int i = 0; i < N; i++) {
            ct[i]=new CounterThreds(acc);
            ct[i].start();
        }
        
        for(int i=0; i<N;i++){
            try{
                ct[i].join();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Accumulatore vale:" + acc.getValue());
    }
}
