


public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        Consumi c = new Consumi();
        SimulaConsumi sc = new SimulaConsumi(c);
        Thread tsc = new Thread(sc);
        tsc.start();

        float corrente = 0.0F;
        float precedente = 0.0F;
        int count = 0;
        while(true){
            try {
                //dovrebbe dormire nove secondo ma ne uso 2 per test
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            corrente = c.getCarburante();
            System.out.println("Consumi: "+corrente);
            if(corrente>precedente)
                if(corrente-precedente>(precedente*30)/100)
                    System.out.println("Warning: si invita a una guida piu' sostenibile");
            
            if(corrente>20)
                count++;
            else
                count=0;

            if(count==3){
                sc.terminaSimulazioneConsumi();
                break;
            }

        
            precedente=corrente;
        }

        //aspetto terminazione thread tsc
        try {
            tsc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termine simulazione consumi");
    }
}
