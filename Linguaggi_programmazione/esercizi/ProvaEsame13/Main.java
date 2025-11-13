import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Spettacolo> listaSpettacoli = new ArrayList<>();
    List<Visualizzazione> listaVisualizzazione = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("spettacoli.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] split;
        if (riga.trim().isEmpty()) continue;
        String titolo = riga;
        riga = reader.readLine();
        split = riga.split(" ");
        int codice = Integer.parseInt(split[0]);
        String tipo = split[1];
        if(tipo.equals("serie")){
          riga = reader.readLine();
          split = riga.split(" ");
          int stagione = Integer.parseInt(split[0]);
          int nPuntate = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String produttore = riga;
          riga = reader.readLine();
          int anno = Integer.parseInt(riga);
          listaSpettacoli.add(new Serie(titolo, tipo, produttore, codice, anno, stagione, nPuntate));
        }else{
          riga = reader.readLine();
          String durata = riga;
           riga = reader.readLine();
          String produttore = riga;
          riga = reader.readLine();
          int anno = Integer.parseInt(riga);
          listaSpettacoli.add(new Film(titolo, tipo, produttore, codice, anno, anno));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    try(BufferedReader reader2 = new BufferedReader(new FileReader("visualizzazioni.txt"))){
      String riga;
      while((riga = reader2.readLine()) != null){
        String[] split;
        if(riga.trim().isEmpty()) continue;
        split = riga.split(" ");
        int codice = Integer.parseInt(split[0]);
        String nome = split[1];
        String cognome = split[2];
        riga = reader2.readLine();
        split = riga.split(" ");
        List<Integer> listaCodiciSpettacoli = new ArrayList<>();
        for(int i = 0; i < split.length; i++){
          int num = Integer.parseInt(split[i]);
          listaCodiciSpettacoli.add(num);
        }
        listaVisualizzazione.add(new Visualizzazione(codice, nome, cognome, listaCodiciSpettacoli));
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("--------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "Tipo", "Tit", "Cod", "Stagione", "N° punt", "Dur", "Anno", "Prod");
    for(Spettacolo s : listaSpettacoli){
      if(s.getTipo().equals("serie")){
        Serie ser = (Serie) s;
        System.out.printf("%-20s %-20s %-20d %-20d %-20d %-20s %-20d %-20s%n", 
          ser.getTipo(),
          ser.getTitolo(),
          ser.getCodice(),
          ser.getStagione(),
          ser.getnPuntate(),
          "-",
          ser.getAnno(),
          ser.getProduttore()
        );
      }else{
        Film film = (Film) s;
        System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20s %-20d %-20s%n", 
          film.getTipo(),
          film.getTitolo(),
          film.getCodice(),
          "-",
          "-",
          film.getDuarata(),
          film.getAnno(),
          film.getProduttore()
        );
      }
    }
    System.out.println("--------------------------------------------");

    System.out.println("\n=== Visualizzazioni per iscritto ===");
    for(Visualizzazione v : listaVisualizzazione){
      System.out.println(v.getNome() + " " + v.getCognome());
      for(int codiceSpettacolo : v.getListaCodiciSpettacoli()){
        for(Spettacolo s : listaSpettacoli){
          if(s.getCodice() == codiceSpettacolo){
            System.out.println("\t" + s.getTitolo() + " (" + s.getTipo() + ")");
          }
        }
      }
    }
    System.out.println("--------------------------------------------");
    int count = 0;
    for(Visualizzazione v : listaVisualizzazione){
      System.out.println(v.getNome() + " " + v.getCognome());
      for(int codiceSpettacolo : v.getListaCodiciSpettacoli()){
        count++;
      }
      System.out.println("Numero spettacoli visti: " + count);
    }
    System.out.println("--------------------------------------------");
  }
}
