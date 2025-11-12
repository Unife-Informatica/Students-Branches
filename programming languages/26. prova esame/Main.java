public class Main {

    public static void main(String[] args) {
        Transazioni transazioni = new Transazioni("ordini.txt");

        transazioni.printTable();

        System.out.println(transazioni.stampaCopieVendute());

        System.out.println(transazioni.getIncasso());
    }
}
