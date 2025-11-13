import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Partita> listaPartite = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("partite.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] split;
        split = riga.split(" ");
        if(split[0].equals("c")){
          listaPartite.add(new Casa(split[0], split[2], split[3], split[4], Integer.parseInt(split[5]), split[1]));
        }else{
          listaPartite.add(new Casa(split[0], split[2], split[3], split[4], Integer.parseInt(split[5]), split[1]));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("------------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", "Palazzetto", "Città", "Data", "Ora", "Risultato");
    for(Partita p : listaPartite){
      if(p.getTipoPartita().equals("c")){
        System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", p.getDettaglio(), "-", p.getData(), p.getOra(), p.getRisultato());
      }else{
        System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", "-", p.getDettaglio(), p.getData(), p.getOra(), p.getRisultato());
      }
    }
    System.out.println("------------------------------------------------");
    System.out.println("Partite vinte in casa");
    for(Partita p : listaPartite){
      if(p.getTipoPartita().equals("c") && p.getVittoria() == 1){
        System.out.printf("%-20s %-20s %-20s%n", p.getDettaglio(), p.getData(), p.getRisultato());
      }
    }
    System.out.println("------------------------------------------------");
    System.out.println("Partite vinte fuori casa");
    for(Partita p : listaPartite){
      if(p.getTipoPartita().equals("f") && p.getVittoria() == 1){
        System.out.printf("%-20s %-20s %-20s%n", p.getDettaglio(), p.getData(), p.getRisultato());
      }
    }
    System.out.println("------------------------------------------------");
    System.out.println("Scrivi una citta: ");
    Scanner console = new Scanner(System.in);
    String cittaDaTrovare = console.nextLine();
    boolean trovato = false;
    for(Partita p : listaPartite){
      if(p.getTipoPartita().equals("f")){
        if(p.getDettaglio().equalsIgnoreCase(cittaDaTrovare)){
          System.out.printf("%-20s %-20s %-20s%n", p.getDettaglio(), p.getData(), p.getRisultato());
          trovato = true;
        }
      }
    }
    if(!trovato){
      System.out.println("Partita ancora non giocata");
    }
    System.out.println("------------------------------------------------");
  }
}
