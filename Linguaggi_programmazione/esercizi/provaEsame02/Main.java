import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    List<Automobile> listaAuto = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("ordini.txt"))){
      String riga;
      String[] parti;
      while((riga = reader.readLine()) != null){
        parti = riga.split(" ");
        if(parti[0].equals("b")){
          listaAuto.add(new Berlina(parti[0], parti[1], parti[2], Integer.parseInt(parti[4]), Integer.parseInt(parti[5]), Double.parseDouble(parti[3])));
        }else{
          listaAuto.add(new Fuoristrada(parti[0], parti[1], parti[2], Integer.parseInt(parti[4]), Integer.parseInt(parti[5]), Integer.parseInt(parti[3])));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.printf("%-10s %-15s %-15s %-12s %-10s%n", 
    "Codice", "Marca", "Modello", "Bagagliaio", "Marce");
    System.out.println("---------------------------------------------------------------");

    for (Automobile a : listaAuto) {
      if (a.getTipo().equals("b")) {
        System.out.printf("%-10s %-15s %-15s %-12s %-10s%n", 
        a.getCodice(), 
        a.getProduttore(), 
        a.getModello(), 
        Double.parseDouble(a.getDatoExtra()),
        "-");
      } else {
        System.out.printf("%-10s %-15s %-15s %-12s %-10s%n", 
        a.getCodice(), 
        a.getProduttore(), 
        a.getModello(), 
        "-",
        Integer.parseInt(a.getDatoExtra()));
      }
    }

    System.out.println("---------------------------------------------------------------");
    System.out.printf("%-10s%n", "Range: 800-1000");
    for(Automobile a : listaAuto){
      if(a.getPeso() >= 800 &&  a.getPeso() <= 1000){
        System.out.printf("%-10d%n", a.getPeso());
      }
    }

    System.out.println("---------------------------------------------------------------");
    System.out.printf("%-10s%n", "Range: 1000-1500");
    for(Automobile a : listaAuto){
      if(a.getPeso() >= 1000 &&  a.getPeso() <= 1500){
        System.out.printf("%-10d%n", a.getPeso());
      }
    }

    System.out.println("---------------------------------------------------------------");
    System.out.printf("%-10s%n", "Range: 1500-2000");
    for(Automobile a : listaAuto){
      if(a.getPeso() >= 1500 &&  a.getPeso() <= 2000){
        System.out.printf("%-10d%n", a.getPeso());
      }
    }

    Scanner console = new Scanner(System.in);
    System.out.println("---------------------------------------------------------------");
    System.out.printf("%nInserisci la marca di cui vuoi vedere i modelli: ");
    String marca = console.nextLine();
    System.out.printf("%-10s%n", "Marca");
    for(Automobile a : listaAuto){
      if(a.getProduttore().equals(marca)){
        System.out.printf("%-10s%n", a.getModello());
      }
    }
  }
}
