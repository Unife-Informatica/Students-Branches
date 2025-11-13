import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Prodotto> listaProdotto = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("inventario.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] split = riga.split(" ");
        if(split[0].equals("toner")){
          String tipoProdotto = split[0];
          int codiceProdotto = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String modello = riga;
          riga = reader.readLine();
          String produttore = riga;
          riga = reader.readLine();
          String data = riga;
          riga = reader.readLine();
          int prezzo = Integer.parseInt(riga);
          riga = reader.readLine();
          String modelloStampante = riga;
          List<Magazzino> listaMagazzino = new ArrayList<>();
          while((riga = reader.readLine()) != null && !riga.trim().isEmpty()){
            int nPezzi = Integer.parseInt(riga);
            listaMagazzino.add(new Magazzino(nPezzi));
          }
          listaProdotto.add(new Toner(tipoProdotto, codiceProdotto, modello, produttore, data, prezzo, modelloStampante, listaMagazzino));
        }else{
          String tipoProdotto = split[0];
          int codiceProdotto = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String modello = riga;
          riga = reader.readLine();
          String produttore = riga;
          riga = reader.readLine();
          String data = riga;
          riga = reader.readLine();
          int prezzo = Integer.parseInt(riga);
          riga = reader.readLine();
          int peso = Integer.parseInt(riga);
          List<Magazzino> listaMagazzino = new ArrayList<>();
          while((riga = reader.readLine()) != null && !riga.trim().isEmpty()){
            int nPezzi = Integer.parseInt(riga);
            listaMagazzino.add(new Magazzino(nPezzi));
          }
          listaProdotto.add(new Stampante(tipoProdotto, codiceProdotto, modello, produttore, data, prezzo, peso, listaMagazzino));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("----------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "Tipo", "Codice", "Modello", "Produttore", "Data", "Prezzo", "Modello Stampante", "Peso");
    for(Prodotto p : listaProdotto){
      if(p.getTipoProdotto().equals("toner")){
        System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20d %-20s %-20s%n", p.getTipoProdotto(), p.getCodiceProdotto(), p.getModello(), p.getProduttore(), p.getData(), p.getPrezzo(), p.getDettaglio(), "-");
      }else{
        System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20d %-20s %-20s%n", p.getTipoProdotto(), p.getCodiceProdotto(), p.getModello(), p.getProduttore(), p.getData(), p.getPrezzo(), "-", p.getDettaglio());
      }
    }
    System.out.println("----------------------------------");

    Map<String, Integer> conteggioModelli = new HashMap<>();
    for(Prodotto p : listaProdotto){
      for(Magazzino m : p.getListaMagzzino()){
        conteggioModelli.put(p.getModello(), conteggioModelli.getOrDefault(p.getModello(), 0) + m.getNPezzi());
      }
    }

    System.out.printf("%-40s %-10s%n", "Modello", "Occorrenze");
    System.out.println("----------------------------------");
    for(Map.Entry<String,Integer> entry : conteggioModelli.entrySet()){
      System.out.printf("%-40s %-10d%n", entry.getKey(), entry.getValue());
    }
    System.out.println("----------------------------------");

    for(Prodotto p : listaProdotto){
      double somma = 0;
      int cont = 0;
      for(Magazzino m : p.getListaMagzzino()){
        somma+=m.getNPezzi();
        cont++;
      }
      System.out.println("Media: " + somma/cont);
    }
  }
}
