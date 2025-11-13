import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Prodotto> listaProdotti = new ArrayList<>();
    double totPrezzo = 0.0;
    try(BufferedReader reader = new BufferedReader(new FileReader("prodotti.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] valori = riga.split(" ");
        listaProdotti.add(new Prodotto(Integer.parseInt(valori[0]), valori[1],  Double.parseDouble(valori[2])));
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    Scanner console = new Scanner(System.in);

    while(true){
      System.out.println("Inserisci il codice e la quantità del prodotto separati da -: ");
      String input = console.nextLine();

      if(input.equalsIgnoreCase("fine")){
        System.out.println("Programma terminato");
        System.out.println("Totale pagato: " + totPrezzo);
        break;
      }
     try{
        ValidatoreInput.validaInput(input, listaProdotti);
        double prezzo = ValidatoreInput.TrovaPrezzoESomma(input, listaProdotti);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("acquisti.txt"))){
          bw.write(input);
          bw.write("-"+prezzo);
          totPrezzo+=prezzo;
          bw.newLine();
        }
     }catch(FormatoInputNonValidoException e){
      System.out.println("Errore di formato - " + e.getMessage());
     }catch(ProdottoNonValidoException e){
      System.out.println("Errore codice - " + e.getMessage());
     }catch(QuantitaNonValidaRuntimeException e){
      System.out.println("Errore quantità - " + e.getMessage());
     }catch(IOException e){
      System.out.println("Errore scrittura file");
     }
    }
  }
}
