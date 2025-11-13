import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    List<Scontrino> listaSc = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("scontrinti.txt"))){
      String riga = reader.readLine();
      while(riga != null && !riga.trim().isEmpty()){
        String[] parti = riga.split(" ");
        switch (parti[0]) {
          case "privato":
            String[] parti2 = riga.split(" ");
            int id;
            String tipoCliente, data, nome, cognome, indirizzoPrivato, cf;;
            while((riga=reader.readLine()) != null){

            }
            
          break;

          case "azienda":
            
          break;
        
          default:
            System.out.println("Tipologia cliente non riconosciuta.");
            break;
        }
      }

    }catch(IOException e){
      e.printStackTrace();;
    }
  }
}
