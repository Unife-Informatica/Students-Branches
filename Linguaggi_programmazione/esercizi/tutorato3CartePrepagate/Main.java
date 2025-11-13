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
    List<CartaPrepagata> listaCarte = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("carte.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] valori = riga.split(" ");
        listaCarte.add(new CartaPrepagata(valori[0], Integer.parseInt(valori[1]), Boolean.parseBoolean(valori[2])));
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    while(true){
      Scanner console = new Scanner(System.in);
      CartaBrano cb = new CartaBrano();
      for(CartaPrepagata c : listaCarte){
        System.out.println(c.getCodice() + " " + c.getNBraniDisp() + " " + c.getStato());
      }
      System.out.println("Scegli una carta prepagata tramite il suo codice: ");
      String sceltaCarta = console.nextLine();
      if(sceltaCarta.equalsIgnoreCase("fine")){
        System.out.println("Programma terminato");
        break;
      }else{
        int scelta;
        do{
          System.out.println("1 - Attiva la carta.\n");
          System.out.println("2 - Acquista brani.\n");
          System.out.println("3 - Ricarica un brano.\n");
          System.out.println("4 - Verifica quanti brani restano.\n");
          System.out.println("0 - Torna alla scelta della carta.\n");
          System.out.println("Scelta: ");
          scelta = Integer.parseInt(console.nextLine());
          switch (scelta) {
            case 1:
            try {
              cb.attivaCarta(sceltaCarta, listaCarte);
              scriviLog("Carta " + sceltaCarta + " attivata.");
            } catch (AttivazioneCartaException e) {
              System.out.println("Errore: " + e.getMessage());
            }
            break;

            case 2:
            try {
              cb.acquistoBrani(sceltaCarta, listaCarte);
              scriviLog("Effettuato acquisto brani per carta " + sceltaCarta + ".");
            } catch (AcquistoBraniException e) {
              System.out.println("Errore: " + e.getMessage());
            }
            break;
              
            case 3:
            try {
              cb.ricaricaCarta(sceltaCarta, listaCarte);
              scriviLog("Carta " + sceltaCarta + " ricaricata.");
            } catch (RicaricaBranoException e) {
              System.out.println("Errore: " + e.getMessage());
            }
            break;

            case 4:
              for(CartaPrepagata aux : listaCarte){
                if(aux.getCodice().equals(sceltaCarta)){
                  System.out.println(aux.getNBraniDisp());
                }
              }
              
            break;

            case 0:
              System.out.println("Stai tornando alla scelta della carta.");
            break;
          
            default:
              System.out.println("Scelta non valida!");
              break;
          }
        }while(scelta != 0);
      }
    }
  }
  public static void scriviLog(String messaggio) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("operazioni.txt", true))) {
      bw.write(messaggio);
      bw.newLine();
    } catch (IOException e) {
      System.out.println("Errore nella scrittura del file di log: " + e.getMessage());
    }
  }
}


