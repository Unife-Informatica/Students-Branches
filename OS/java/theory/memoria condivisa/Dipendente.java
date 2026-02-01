public class Dipendente extends Thread {

    private Deposito d;
    private final int id;

    public Dipendente(Deposito d, int id) {
        this.d = d;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int items = (int) (Math.random() * 100);
            d.addItems(items);
            System.out.println("[Dipendente " + id + "]: +" + items);
        }
    }
}
