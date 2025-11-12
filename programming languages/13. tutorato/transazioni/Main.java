import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Ordine> ordini = new ArrayList<>();

        // PayPal (non valido)
        ordini.add(new Ordine("0", "Lavatrice", new PayPal(199.99, "email.com", "123")));

        // Bonifico (valido)
        ordini.add(new Ordine("1", "Frigorifero", new BonificoBancario(50.17, "IT123456", 3042)));

        // Carta di Credito (valido)
        ordini.add(new Ordine("2", "Tostapane", new CartaDiCredito(35.13, "gdsfv3", "123", "Topolino")));

        // PayPal (valido e rimborsabile)
        ordini.add(new Ordine("3", "Aspirapolvere", new PayPal(89.50, "user@email.com", "password123")));

        for (Ordine ordine : ordini) {
            ordine.processaOrdine();
        }

        System.out.println("\n--- RIMBORSI ---");
        for (Ordine ordine : ordini) {
            ordine.rimborsaOrdine();
        }
    }
}

