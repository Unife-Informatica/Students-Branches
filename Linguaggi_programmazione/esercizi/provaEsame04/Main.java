import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Prodotto> listaProdotti = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("vendite.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] split = riga.split(" ");
        if(split[0].equals("libro")){
          String tipoProdotto = split[0];
          int codiceProdotto = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String titolo = riga;
          riga = reader.readLine();
          String autori = riga;
          riga = reader.readLine();
          int prezzo = Integer.parseInt(riga);
          riga = reader.readLine();
          String ISBN = riga;
          listaProdotti.add(new Libro(tipoProdotto, codiceProdotto, titolo, autori, prezzo, ISBN));
        }else if(split[0].equals("CD")){
          String tipoProdotto = split[0];
          int codiceProdotto = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String titolo = riga;
          riga = reader.readLine();
          String autori = riga;
          riga = reader.readLine();
          int prezzo = Integer.parseInt(riga);
          riga = reader.readLine();
          int durata = Integer.parseInt(riga);
          listaProdotti.add(new CD(tipoProdotto, codiceProdotto, titolo, autori, prezzo, durata));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("------------------------------------------------------");
    System.out.printf("%-10s %-10s %-30s %-30s %-10s %-15s %-10s%n",
    "Tipo", "Codice", "Titolo", "Autori", "Prezzo", "ISBN", "Durata");
    for (Prodotto p : listaProdotti) {
      if (p.getTipoProdotto().equals("libro")) {
        System.out.printf("%-10s %-10d %-30s %-30s %-10d %-15s %-10s%n",
        p.getTipoProdotto(), p.getCodiceProdotto(), p.getTitolo(), p.getAutori(),
        p.getPrezzo(), p.getDettaglio(), "-");
      } else {
        System.out.printf("%-10s %-10d %-30s %-30s %-10d %-15s %-10s%n",
        p.getTipoProdotto(), p.getCodiceProdotto(), p.getTitolo(), p.getAutori(),
        p.getPrezzo(), "-", p.getDettaglio());
      }
    }
    System.out.println("------------------------------------------------------");

    Map<String, Integer> conteggioProdotti = new HashMap<>();
    for(Prodotto p : listaProdotti){
      conteggioProdotti.put(p.getAutori(), conteggioProdotti.getOrDefault(p.getAutori(), 0)+ 1);
    }

    System.out.printf("%-30s %-10s%n", "Autore", "Occorrenze");
    System.out.println("------------------------------------------------------");
    for(Map.Entry<String, Integer> entry : conteggioProdotti.entrySet()){
      System.out.printf("%-30s %-10d%n", entry.getKey(), entry.getValue());
    }
    System.out.println("------------------------------------------------------");
    double somma = 0, cont = 0;
    for(Prodotto p : listaProdotti){
      somma+=p.getPrezzo();
      cont++;
    }
    System.out.println("Prezzo Medio: " + somma/cont);
  }
}
