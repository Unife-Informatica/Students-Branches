
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Acquisti {
    ListaProdotti prodotti = new ListaProdotti(config.PRODUCTS);

    int codiceProdotto, quantita;

    public Acquisti(String request) throws FormatoInputNonValidoException, ProdottoNonValidoException {
        autentica(request);
    }

    private void autentica(String request) throws FormatoInputNonValidoException, ProdottoNonValidoException {
        String[] requests;
        try {
            requests = request.split("-");
        } catch (PatternSyntaxException e) {
            throw new FormatoInputNonValidoException("Formato input non valido");
        }

        if (requests.length != 2) {
            throw new FormatoInputNonValidoException("Formato input non valido");
        }

        try {
            this.codiceProdotto = Integer.parseInt(requests[0]);
            this.quantita = Integer.parseInt(requests[1]);
        } catch (NumberFormatException e) {
            throw new FormatoInputNonValidoException("Formato input non valido");
        }

        if (quantita <= 0) {
            throw new FormatoInputNonValidoException("Formato input non valido");
        }
        
        prodotti.isValidId(codiceProdotto);
    }

    public void updateFile(String filePath) {
        try (PrintWriter outFile = new PrintWriter(new FileWriter(filePath, true))) {
            outFile.println(this.codiceProdotto + " " + this.quantita);
            System.out.println("Transazione registrata");
        } catch (IOException e) {
            System.out.println("[Errore]: spazio insufficiente o file non accessibile");
        }
    }

    public static double getTotale() {
        ListaProdotti prodotti = new ListaProdotti(config.PRODUCTS);
        double totale = 0.0;
        try (Scanner sc = new Scanner(new File(config.TRANSAZIONI))) {
            sc.useLocale(Locale.US);
            while (sc.hasNext()) {
                double tmp = 0.0;
                int id = -1, quantita = -1;
                if (sc.hasNextInt()) {
                    id = sc.nextInt();
                }
                if(sc.hasNextInt()) {
                    quantita = sc.nextInt();
                }
                if (quantita != -1 && id != -1) {
                    try {
                        tmp = prodotti.getProductPrice(id) * quantita;
                    } catch (ProdottoNonValidoException e) {
                        System.out.println("[Errore]: errore durante il calcolo del totale.");
                    }
                }
                totale += tmp;
            }
        } catch (IOException e) {
            System.err.println("[Errore]: " + config.TRANSAZIONI + " non trovato.");
        }
        return totale;
    }  
}
