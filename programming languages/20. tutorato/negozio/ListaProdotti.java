
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ListaProdotti {

    List<Prodotto> listaProdotti = new ArrayList<>();

    public ListaProdotti(String filePath) {
        getDataFromFile(filePath);
    }

    private void getDataFromFile(String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            sc.useLocale(Locale.US);
            while (sc.hasNext()) {
                Prodotto tmp = new Prodotto();
                if (sc.hasNextInt()) {
                    tmp.setId(sc.nextInt());
                }
                if(sc.hasNext()) {
                    tmp.setNome(sc.next());
                }
                if(sc.hasNext()) {
                    tmp.setPrezzo(sc.nextDouble());
                }
                this.listaProdotti.add(tmp);
            }
        } catch (IOException e) {
            System.err.println("[Errore]: " + filePath + " non trovato.");
        }
    }

    public void printList() {
        System.out.println("ID\tNome\tPrezzo");
        for(Prodotto p : listaProdotti) {
            System.out.println(p.getId() + "\t" + p.getNome() + "\t" + p.getPrezzo());
        }
    }

    public void isValidId(int id) throws ProdottoNonValidoException {
        for(Prodotto p : listaProdotti) {
            if(p.id == id) return;
        }
        throw new ProdottoNonValidoException("Prodotto '" + id + "' non valido");
    }

    public double getProductPrice(int id) throws ProdottoNonValidoException {
        for(Prodotto p : listaProdotti) {
            if(p.getId() == id) {
                return p.getPrezzo();
            }
        }
        throw new ProdottoNonValidoException("Prodotto '" + id + "' non valido");
    }
}
