public class Main {
    public static void main(String[] args) {
        int codice_ricercatore = -1;
        if(args.length != 1) {
            System.out.println("Uso: java Main <codice_ricercatore>");
            System.exit(1);
        }

        try {
            codice_ricercatore = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("[Errore]: il valore inserito deve essere un numero intero");
            System.exit(2);
        }

        Reperti listaReperti = new Reperti("reperti.txt");
        Ricercatori listaRicercatori = new Ricercatori("ricercatori.txt");

        listaReperti.printList();
        listaRicercatori.printList();

        try {
            System.out.println(listaRicercatori.getNameById(codice_ricercatore) + " ha effettuato in media " + listaRicercatori.getMediaConsulatazione(codice_ricercatore) + " giorni di consultazione");
        } catch(UserNotFoundException e) {
            System.err.println("[Errore]: " + e.getMessage());
        }

        System.exit(0);
    }
}
