import java.util.ArrayList;
import java.util.List;

public class Videoteca {
  public static void main(String[] args) {
    double totPenali = 0.0;
    List<Noleggio> listaNoleggi = new ArrayList<>();
    Film f1 = new Film("A1", "Terminator", "Azione");
    Film f2 = new Film("C1", "Una notte da leoni", "Commedia");
    Film f3 = new Film("D1", "Titanic", "Dramma");

    listaNoleggi.add(new Noleggio(f1, "0", 5, 0,0));
    listaNoleggi.add(new Noleggio(f2, "1", 1, 0, 0));
    listaNoleggi.add(new Noleggio(f3, "3", 3, 0, 0));

    for(Noleggio noleggio : listaNoleggi){
      System.out.println("FILM = [Codice = " + noleggio.getCodice() + ", titolo = " + noleggio.getTitolo() + ", penale = " + noleggio.getPenaleBase() + "]\n");
      System.out.println("Codice dell'utente = " + noleggio.getCodiceCliente() + "\n");
      System.out.println("Giorni di ritardo = " + noleggio.getGiorniRitardo() + "\n");
      System.out.println("Penale da pagare = " + noleggio.calcolaPenaleTot() + "\n");
      totPenali+=noleggio.calcolaPenaleTot();
    }
    System.out.println("Ammontare complessivo delle penali = " + totPenali + "\n");
  }
}
