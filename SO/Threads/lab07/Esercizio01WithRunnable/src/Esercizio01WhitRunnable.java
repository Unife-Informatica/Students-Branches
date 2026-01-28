public class Esercizio01WhitRunnable {

    final static int N=25;
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        Accumulatore acc = new Accumulatore(0.0);

        Thread ct[]=new Thread[N];
        for(int i=0;i<N;i++){
            ct[i]=new Thread(new CounterThreads(acc));
            ct[i].start();
        }
        for(int i=0;i<N;i++){
            try{
                ct[i].join();
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        System.out.println("Accumulatore: "+acc.getValue());
    }
}
