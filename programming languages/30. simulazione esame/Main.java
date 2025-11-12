public class Main {
    public static void main(String[] args) {
        Dipendenti dipendenti = new Dipendenti("dipendenti.txt");
        Clienti clienti = new Clienti("clienti.txt");

        dipendenti.printList();
        clienti.printList();

        dipendenti.printMigliore(clienti.getList());
    }
}
