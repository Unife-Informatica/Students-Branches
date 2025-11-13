import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Cliente> listaClienti = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("clienti.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] split = riga.split(" ");
        if(split[0].equals("privato")){
          String tipoCliente = split[0];
          int codiceCliente = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String indirizzo = riga;
          riga = reader.readLine();
          String data = riga;
          riga = reader.readLine();
          String nome = riga;
          List<Premio> listaPremi = new ArrayList<>();
          while((riga = reader.readLine()) != null && !riga.trim().isEmpty()){
            int importo = Integer.parseInt(riga);
            listaPremi.add(new Premio(importo)); 
          }
          listaClienti.add(new Privato(tipoCliente, codiceCliente, indirizzo, data, nome, listaPremi));
        }else{
          String tipoCliente = split[0];
          int codiceCliente = Integer.parseInt(split[1]);
          riga = reader.readLine();
          String indirizzo = riga;
          riga = reader.readLine();
          String data = riga;
          riga = reader.readLine();
          String ragioneSoc = riga;
          riga = reader.readLine();
          int fatturato = Integer.parseInt(riga);
          List<Premio> listaPremi = new ArrayList<>();
          while((riga = reader.readLine()) != null && !riga.trim().isEmpty()){
            int importo = Integer.parseInt(riga);
            listaPremi.add(new Premio(importo)); 
          }
          listaClienti.add(new Azienda(tipoCliente, codiceCliente, indirizzo, data, ragioneSoc, fatturato, listaPremi));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("-----------------------------------------");
    System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %-25s%n", "Tipo", "Codice", "Nome", "Ragione Sociale", "Indirizzo", "Data", "Fatturato");
    for(Cliente c : listaClienti){
      if (c.getTipoCliente().equalsIgnoreCase("privato")) {
        Privato p = (Privato) c; // cast da Cliente → Privato
        System.out.printf("%-25s %-25d %-25s %-25s %-25s%n",
            p.getTipoCliente(), p.getCodiceIdentif(), p.getIndirizzo(), p.getData(), p.getNome());
    } 
    }
  }
}
