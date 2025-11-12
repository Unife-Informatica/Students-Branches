public class Main {

    public static void main(String[] args) {
        Prodotti prodotti = new Prodotti("vendite.txt");

        prodotti.printVendite();

        System.out.println(prodotti.prodottiPerAutore());
        System.out.println(prodotti.prezzoMedio());
    }
}
