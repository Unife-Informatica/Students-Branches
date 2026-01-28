public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("Esercizio simulazione cosnumi");

        Consumi c = new Consumi();
        SimulaConsumi sc = new SimulaConsumi(c);
        Thread tsc = new Thread(sc);
        tsc.start();

        int count = 0;
        float corrente = 0.0F;
        float precedente = 0.0F;
        while(true){
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            corrente=c.getCarburante();
            System.out.println("Consumi: "+corrente);
            if(corrente>precedente){
                if(corrente-precedente>(precedente*30)/100){
                    System.out.println("Warning! Si invita ad una guida piu' sostenibile");
                }
            }
            if(corrente>5)
                count++;
            else
                count=0;

            if(count==3){
                sc.terminaSimulazioneConsumi();
                break;
            }

            precedente=corrente;
        }

        System.out.println("Attendo terminazione");
        try {
            tsc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fine");
    }
}
