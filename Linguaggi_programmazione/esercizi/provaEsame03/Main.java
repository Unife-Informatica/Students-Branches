import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Transazione> listaTransaz = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("transazioni.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] parti = riga.split(" ");
        if(parti[0].equals("f")){
          List<Libro> listaLibri = new ArrayList<>();
          String tipoTr = parti[0];
          int id = Integer.parseInt(parti[1]);
          String data = parti[2];
          String citta = parti[3];
          while((riga = reader.readLine()) != null && !riga.trim().isEmpty()){
            String titolo = riga;
            riga = reader.readLine();
            String autore = riga;
            riga = reader.readLine();
            int prezzo = Integer.parseInt(riga);
            listaLibri.add(new Libro(titolo, autore, prezzo));
          }
          listaTransaz.add(new TransazNegozio(tipoTr, id, data, listaLibri, citta));
        }else{
          List<Libro> listaLibri = new ArrayList<>();
          String tipoTr = parti[0];
          int id = Integer.parseInt(parti[1]);
          String data = parti[2];
          String ip = parti[3];
          while((riga = reader.readLine()) != null && !riga.trim().isEmpty()){
            String titolo = riga;
            riga = reader.readLine();
            String autore = riga;
            riga = reader.readLine();
            int prezzo = Integer.parseInt(riga);
            listaLibri.add(new Libro(titolo, autore, prezzo));
          }
          listaTransaz.add(new TransazNegozio(tipoTr, id, data, listaLibri, ip));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }
    System.out.println("--------------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", "ID","Data","Città","IndirizzoIP","Totale");
    for(Transazione t : listaTransaz){
      if(t.getTipoTr().equals("f")){
        System.out.printf("%-20d %-20s %-20s %-20s %-20d%n", t.getId(), t.getData(), t.getDatoExtra(), "-", t.getPrezzoTotale());
      }else{
        System.out.printf("%-20d %-20s %-20s %-20s %-20d%n", t.getId(), t.getData(), "-", t.getDatoExtra(), t.getPrezzoTotale());
      }
    }
    System.out.println("--------------------------------------------------");
    int incassoComplessivo = 0;
    for(Transazione t : listaTransaz){
      incassoComplessivo+=t.getPrezzoTotale();
    }
    System.out.printf("%-10s%n", "Totale complessivo");
    System.out.printf("%-10d%n", incassoComplessivo);
    System.out.println("--------------------------------------------------");

    Map<String, Integer> conteggioLibri = new HashMap<>();
    for(Transazione t : listaTransaz){
      for(Libro l : t.getListaLibri()){
        conteggioLibri.put(l.getTitolo(), conteggioLibri.getOrDefault(l.getTitolo(), 0) + 1);
      }
    }

    System.out.printf("%-40s %-10s%n", "Titolo", "Occorrenze");
    System.out.println("--------------------------------------------------");
    for(Map.Entry<String,Integer> entry : conteggioLibri.entrySet()){
      System.out.printf("%-40s %-10d%n", entry.getKey(), entry.getValue());
    }
    System.out.println("--------------------------------------------------");
  }
}
