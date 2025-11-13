import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Evento> listaEventi = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("eventi.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        if(riga.trim().isEmpty())continue;
        String[] split;
        String nomeEvento = riga;
        riga = reader.readLine();
        split = riga.split(" ");
        int codiceEvento = Integer.parseInt(split[0]);
        String tipo = split[1];
        int nPosti = Integer.parseInt(split[2]);
        if(tipo.equals("partita")){
          riga = reader.readLine();
          String sport = riga;
          riga = reader.readLine();
          String struttura = riga;
          riga = reader.readLine();
          String data = riga;
          riga = reader.readLine();
          float prezzo = Float.parseFloat(riga);
          List<Prenotazione> listaPrenotazioni = new ArrayList<>();
          try(BufferedReader readerPartita = new BufferedReader(new FileReader("prenotazioni.txt"))){
            while((riga = readerPartita.readLine()) != null){
              if(riga.trim().isEmpty())continue;
              split = riga.split(" ");
              int codiceEventoPren = Integer.parseInt(split[0]);
              if(codiceEventoPren == codiceEvento){
                String nome = split[1];
                String cognome = split[2];
                int postoAss = Integer.parseInt(split[3]);
                String accompagnatore = split[4];
                listaPrenotazioni.add(new Prenotazione(codiceEventoPren, postoAss, nome, cognome, accompagnatore));
              }
            }
          }catch(IOException e){
            e.printStackTrace();;
          }
          listaEventi.add(new Partita(nomeEvento, tipo, struttura, data, codiceEvento, nPosti, prezzo, sport, listaPrenotazioni));
        }else{
          riga = reader.readLine();
          int duarataConcerto = Integer.parseInt(riga);
          riga = reader.readLine();
          String struttura = riga;
          riga = reader.readLine();
          String data = riga;
          riga = reader.readLine();
          float prezzo = Float.parseFloat(riga);
          List<Prenotazione> listaPrenotazioni = new ArrayList<>();
          try(BufferedReader readerConcerto = new BufferedReader(new FileReader("prenotazioni.txt"))){
            while((riga = readerConcerto.readLine()) != null){
              if(riga.trim().isEmpty())continue;
              split = riga.split(" ");
              int codiceEventoPren = Integer.parseInt(split[0]);
              if(codiceEventoPren == codiceEvento){
                String nome = split[1];
                String cognome = split[2];
                int postoAss = Integer.parseInt(split[3]);
                String accompagnatore = split[4];
                listaPrenotazioni.add(new Prenotazione(codiceEventoPren, postoAss, nome, cognome, accompagnatore));
              }
            }
          }catch(IOException e){
            e.printStackTrace();;
          }
          listaEventi.add(new Concerto(nomeEvento, tipo, struttura, data, codiceEvento, nPosti, prezzo, duarataConcerto, listaPrenotazioni));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("------------------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "Tipo", "Nome", "Cod", "Strut", "Data", "Prz", "N° posti", "Dur", "Sport");
    for(Evento e : listaEventi){
      if(e.getTipo().equals("partita")){
        System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20.2f %-20d %-20s %-20s%n", 
          e.getTipo(),
          e.getNomeEvento(),
          e.getCodiceEvento(),
          e.getStruttura(),
          e.getData(),
          e.getPrezzo(),
          e.getnPosti(),
          "-",
          e.getDettaglio()
        );
      }else{
        System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20.2f %-20d %-20.2f %-20s%n", 
          e.getTipo(),
          e.getNomeEvento(),
          e.getCodiceEvento(),
          e.getStruttura(),
          e.getData(),
          e.getPrezzo(),
          e.getnPosti(),
          Float.parseFloat(e.getDettaglio()),
          "-"
        );
      }
    }
    System.out.println("------------------------------------------------------");
  }
}
