public class Main {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) throws Exception {
        Consumi c = new Consumi();
        SimulaConsumi sc = new SimulaConsumi(c);
        Thread tsc = new Thread(sc);
        tsc.start();
        float corrente = 0.0F;
        float precedente = 0.0F;
        int cont = 0;
        while(true){
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            corrente = c.getConsumi();
            System.out.println("Consumi: "+corrente);
            if(corrente>precedente){
                if(corrente-precedente>(precedente/30)*100)
                    System.out.println("Attenzione segui una guida piu' sostenibile");
            }
            if(corrente > 20)
                cont ++;
            else 
                cont=0;

            if(cont==3){
                sc.terminaSimulazioneConsumi();
                break;
            }
            precedente=corrente;
        }
        try {
            tsc.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
