
import java.util.Scanner;

public class Main {

    public static void main(String[] main) {
        Scanner console = new Scanner(System.in);

        System.out.print("Card code: ");
        String inputID = console.nextLine();
        int selectID = Integer.parseInt(inputID);

        CartaBrano selectCard = new CartaBrano(selectID, "carte.txt");

        while (true) {
            System.err.print("Comando: ");
            String cmd = console.next();
            switch (cmd.toLowerCase()) {
                case "fine" -> {
                    console.close();
                    return;
                }
                case "h" -> {
                    System.out.println("attiva\t\tattiva la carta");
                    System.out.println("acquista\tacquista brani");
                    System.out.println("ricarica\taggiunge brani alla carta");
                    System.out.println("stato\t\tstato della carta selezionata");
                    System.out.println("h\t\thelp");
                    System.out.println("fine\t\tesce");
                }
                case "attiva" -> {
                    try {
                        selectCard.attivaCarta();
                    } catch (CartaGiaAttivataException e) {
                        System.err.println("[Errore]: La carta è gia stata attivata");
                    }
                }
                case "acquista" -> {
                    try {
                        System.out.print("Brani da acquistare: ");
                        int n_brani = Integer.parseInt(console.next());
                        selectCard.acquistaBrani(n_brani);
                    } catch (Exception e) {
                        System.out.println("[Errore]: " + e.getMessage());
                    }
                }
                case "ricarica" -> {
                    try {
                        System.out.print("Brani da aggiungere: ");
                        int n_brani = Integer.parseInt(console.next());
                        selectCard.ricaricaBrani(n_brani);
                    } catch (Exception e) {
                        System.out.println("[Errore]: " + e.getMessage());
                    }
                }
                case "stato" -> {
                    selectCard.printStatus();
                }
                default -> {
                    System.out.println(cmd + " non valido. Digita 'h' per maggiori informazioni.");
                }
            }
        }
    }
}
