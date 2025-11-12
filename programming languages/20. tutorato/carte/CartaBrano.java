
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CartaBrano {

    private int ID, brani;
    private boolean stato;

    public CartaBrano(int ID, String filePath) {
        loadCardData(ID, filePath);
    }

    public int getID() {
        return ID;
    }

    public int getBrani() {
        return brani;
    }

    public boolean getStato() {
        return stato;
    }

    private void setStato(boolean stato) {
        this.stato = stato;
    }

    private void loadCardData(int ID, String filePath) {
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNext()) {
                if ((this.ID = sc.nextInt()) != ID) {
                    sc.nextLine();
                    continue;
                }
                if (sc.hasNext()) {
                    brani = sc.nextInt();
                }
                if (sc.hasNext()) {
                    stato = sc.nextInt() == 1;
                }
                return;
            }
        } catch (IOException e) {
            System.out.println("[Errore]: errore durante la lettura di " + filePath);
        }
    }

    public void attivaCarta() throws CartaGiaAttivataException {
        if (getStato()) {
            throw new CartaGiaAttivataException();
        }
        setStato(true);
    }

    public void acquistaBrani(int n) throws CartaNonAttivataException, Exception {
        if(!getStato()) {
            throw new CartaNonAttivataException("Carta disattivata");
        }
        if(n <= 0) {
            throw new Exception("Valore non valido");
        }
        if(n > brani) {
            throw new Exception("Massimo acquistabile: " + brani);
        }
        brani -= n;
    }

    public void ricaricaBrani(int n) throws CartaNonAttivataException, Exception {
        if(!getStato()) {
            throw new CartaNonAttivataException("Carta disattivata");
        }
        if(n <= 0) {
            throw new Exception("Valore non valido");
        }
        brani += n;
    }

    public void printStatus() {
        System.out.println("ID: " + ID + "\tBrani: " + brani + "\tStato: " + (stato ? "Attiva" : "Non attiva"));
    }
}
