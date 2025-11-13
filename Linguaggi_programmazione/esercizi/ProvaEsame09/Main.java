import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Squadra> listaSquadre = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("squadre.txt"))){
      String riga2;
      while((riga2 = reader.readLine()) != null){
        String nomeSquadra = riga2;
        riga2 = reader.readLine();
        String[] split = riga2.split(" ");
        if(split[1].equals("pallavolo")){
          int codice = Integer.parseInt(split[0]);
          String sport = split[1];
          riga2 = reader.readLine();
          split = riga2.split(" ");
          int nPartiteVinte = Integer.parseInt(split[0]);
          int nPartitePerse = Integer.parseInt(split[1]);
          float nMedioSetVinti = Float.parseFloat(split[2]);
          List<Giocatore> listaGiocatori = new ArrayList<>();
          try(BufferedReader reader2 = new BufferedReader(new FileReader("giocatori.txt"))){
            String riga3;
            while((riga3 = reader2.readLine()) != null){
              String[] split2 = riga3.split(" ");
              int codiceSquadra = Integer.parseInt(split2[0]);
              if(codice == codiceSquadra){
                listaGiocatori.add(new Giocatore(Integer.parseInt(split2[0]), split2[1], Integer.parseInt(split2[2]), Integer.parseInt(split2[3]), split2[4], split2[5]));
              }
            }
          }catch(IOException e){
            e.printStackTrace();
          }
          listaSquadre.add(new Pallavolo(nomeSquadra, codice, sport, nPartiteVinte, nPartitePerse, nMedioSetVinti, listaGiocatori));
        }else{
          int codice = Integer.parseInt(split[0]);
          String sport = split[1];
          riga2 = reader.readLine();
          split = riga2.split(" ");
          int nPartiteVinte = Integer.parseInt(split[0]);
          int nPartitePerse = Integer.parseInt(split[1]);
          float punteggioMedio = Float.parseFloat(split[2]);
          List<Giocatore> listaGiocatori = new ArrayList<>();
          try(BufferedReader reader2 = new BufferedReader(new FileReader("giocatori.txt"))){
            String riga3;
            while((riga3 = reader2.readLine()) != null){
              String[] split2 = riga3.split(" ");
              int codiceSquadra = Integer.parseInt(split2[0]);
              if(codice == codiceSquadra){
                listaGiocatori.add(new Giocatore(Integer.parseInt(split2[0]), split2[1], Integer.parseInt(split2[2]), Integer.parseInt(split2[3]), split2[4], split2[5]));
              }
            }
          }catch(IOException e){
            e.printStackTrace();
          }
          listaSquadre.add(new Pallavolo(nomeSquadra, codice, sport, nPartiteVinte, nPartitePerse, punteggioMedio, listaGiocatori));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("------------------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "Nome della squadra", "codice", "N° partite vinte", "N° partite perse", "Punteggio medio", "N° medio di set vinti", "sport");
    for(Squadra s : listaSquadre){
      if(s.getSport().equals("pallavolo")){
        System.out.printf("%-20s %-20d %-20d %-20d %-20s %-20f %-20s%n", s.getNomeSquadra(), s.getCodice(), s.getDettaglio1(), s.getDettaglio2(), "-", s.getDettaglio3(), s.getSport());
      }else{
        System.out.printf("%-20s %-20d %-20d %-20d %-20f %-20s %-20s%n", s.getNomeSquadra(), s.getCodice(), s.getDettaglio1(), s.getDettaglio2(), s.getDettaglio3(), "-", s.getSport());
      }
    }
    System.out.println("------------------------------------------------------");
    Map<String,Integer> conteggioGiocatori = new HashMap<>();
    for(Squadra s : listaSquadre){
      for(Giocatore g : s.getListaGiocatori()){
        conteggioGiocatori.put(s.getNomeSquadra(), conteggioGiocatori.getOrDefault(s.getNomeSquadra(), 0) + 1);
      }
    }

    System.out.printf("%-20s %-20s%n", "Nome squadra", "Occorrenze");
    System.out.println("------------------------------------------------------");
    for(Map.Entry<String, Integer> entry : conteggioGiocatori.entrySet()){
      System.out.printf("%-20s %-20d%n", entry.getKey(), entry.getValue());
    }
    System.out.println("------------------------------------------------------");
    Scanner console = new Scanner(System.in);
    System.out.println("Inserisci il nome di una squadra: ");
    String nomeS = console.nextLine();
    System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", "Cognome", "Eta", "Numero di maglia", "Ruolo", "Titolare");
    for(Squadra s : listaSquadre){
      for(Giocatore g : s.getListaGiocatori()){
        if(s.getNomeSquadra().equals(nomeS)){
          System.out.printf("%-20s %-20d %-20d %-20s %-20s%n", g.getCognome(), g.getEta(), g.getNumeroMaglia(), g.getRuolo(), g.getIsTitolare());
        }
      }
    }
     System.out.println("------------------------------------------------------");
  }
}
