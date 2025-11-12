public class Main {
    public static void main(String[] args) {
        int campoSelezionato = -1;

        // Controllo degli argomenti
        if(args.length > 1) {
            System.err.println("Uso: " + args[0] + " <codice_campo>");
            System.exit(1);
        }

        try {
            campoSelezionato = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("[Errore]: il numero inserito deve essere un intero");
            System.exit(1);
        }

        Campi listaCampi = new Campi("campi.txt");
        Soci listaSoci = new Soci("giocatori.txt");

        listaCampi.printList();
        listaSoci.printList();

        try {
            System.out.println(listaCampi.incassoTotale(campoSelezionato, listaSoci.getList()));
        } catch (Exception e) {
            System.err.println("[Errore]: " + e.getMessage());
        }
    }
}