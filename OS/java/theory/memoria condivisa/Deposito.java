public class Deposito {

    private int items = 0;

    public Deposito() {
        items = 0;
    }

    public Deposito(int items) {
        this.items = items;
    }

    public synchronized int getItems() {
        return items;
    }

    public synchronized void addItems(int items) {
        this.items += items;
    }
}
