public class Main {

    public static void main() {
        Produzione produzione = new Produzione();
        Macchina[] listaMacchine = new Macchina[10];
        produzione.start();

        try {
            for (int i = 0; i < 10; i++) {
                listaMacchine[i] = new Macchina(produzione);
                listaMacchine[i].start();
            }

            for (int i = 0; i < 10; i++) {
                listaMacchine[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        produzione.stampaProduzione();
    }
}
