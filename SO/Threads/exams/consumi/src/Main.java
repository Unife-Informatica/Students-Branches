public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        System.out.println("\t SIMULAZIONE CONSUMI");

        Consumi c = new Consumi();
        RilevaConsumi rc = new RilevaConsumi(c);
        Thread tsc = new Thread(rc);
        tsc.start();

        int count=0;
        float corrente=0.0F;
        float precedente=0.0F;

        while(true){

            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            corrente = c.getConsumi();
            System.out.println("Consumo attuale: "+corrente);

            if(corrente>precedente){
                if(corrente-precedente>(precedente*30)/100){
                    System.out.println("Attenzione! Si sta conducendo una guida poco sostenibile");
                }
            }

            if(corrente>20)
                count++;
            else
                count=0;

            if(count==3){
                System.out.println("Terminazione della simulazione");
                rc.terminaSimulazioneConsumi();
                break;
            }

            precedente = corrente;
        }

        System.out.println("Attendo la terminazione di SimulzioneConsumi");
        try {
            tsc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finiiiiish");
    }
}
