public class Main {

    public static void main() {
        Deposito d = new Deposito();
        Dipendente[] dipendenti = new Dipendente[10];

        for (int i = 0; i < 10; i++) {
            dipendenti[i] = new Dipendente(d, i);
            dipendenti[i].start();
        }

        try {
            for (int i = 0; i < 10; i++) {
                dipendenti[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------fine-------------");
        System.out.println("Oggetti totali: " + d.getItems());
    }
}
