
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      try (Scanner console = new Scanner(System.in)) {
          String request;
          ListaProdotti prodotti = new ListaProdotti(config.PRODUCTS);

          prodotti.printList();

          while (true) {
              request = console.next();

              // uscita
              if (request == null || request.equalsIgnoreCase("fine")) {
                  System.out.println("Totale: " + Acquisti.getTotale());
                  break;
              }

              try {
                  Acquisti acquisto = new Acquisti(request);
                  acquisto.updateFile(config.TRANSAZIONI);
              } catch (FormatoInputNonValidoException | ProdottoNonValidoException e) {
                  System.out.println("[Errore]: " + e.getMessage());
              }
          }
      }

    }
}
