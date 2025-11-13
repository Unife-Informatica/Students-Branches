import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Filiale> listaFiliali = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("filiali.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        if(riga.trim().isEmpty())continue;
        String nome = riga;
        riga = reader.readLine();
        int codice = Integer.parseInt(riga);
        riga = reader.readLine();
        String indirizzo = riga;
        List<Cliente> listaClienti = new ArrayList<>();
        try(BufferedReader readerClienti = new BufferedReader(new FileReader("clienti.txt"))){
          String rigaC;
          while((rigaC = readerClienti.readLine()) != null){
            if(rigaC.trim().isEmpty())continue;
            String[] splitC = rigaC.split(" ");
            if(splitC[0].equals("privato")){
              String tipoCliente = splitC[0];
              int codiceCliente = Integer.parseInt(splitC[1]);
              rigaC = readerClienti.readLine();
              String nomeCognome = rigaC;
              rigaC = readerClienti.readLine();
              int codFiliale = Integer.parseInt(rigaC);
              rigaC = readerClienti.readLine();
              splitC = rigaC.split(" ");
              List<Integer> listaExFiliali = new ArrayList<>();
              for(int i = 0; i < splitC.length; i++){
                int num = Integer.parseInt(splitC[i]);
                listaExFiliali.add(num);
              }
              rigaC = readerClienti.readLine();
              float premioCorrente = Float.parseFloat(rigaC);
              if(codice == codFiliale){
                listaClienti.add(new Privato(tipoCliente, codiceCliente, codFiliale, listaExFiliali, premioCorrente, nomeCognome));
              }
            }else{
              String tipoCliente = splitC[0];
              int codiceCliente = Integer.parseInt(splitC[1]);
              rigaC = readerClienti.readLine();
              String ragSociale = rigaC;
              rigaC = readerClienti.readLine();
              int codFiliale = Integer.parseInt(rigaC);
              rigaC = readerClienti.readLine();
              splitC = rigaC.split(" ");
              List<Integer> listaExFiliali = new ArrayList<>();
              
              for(int i = 0; i < splitC.length; i++){
                int num = Integer.parseInt(splitC[i]);
                listaExFiliali.add(num);
              }
              rigaC = readerClienti.readLine();
              float premioCorrente = Float.parseFloat(rigaC);
              rigaC = readerClienti.readLine();
              float premioCorrTasse = Float.parseFloat(rigaC);
              if(codice == codFiliale){
                listaClienti.add(new Azienda(tipoCliente, codiceCliente, codFiliale, listaExFiliali, premioCorrente, ragSociale, premioCorrTasse));
              }
            }
          }
        }catch(IOException e){
          e.printStackTrace();
        }
        listaFiliali.add(new Filiale(nome, indirizzo, codice, listaClienti));
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("----------------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "Tipo", "Nome e Cognome", "Rag Soc", "Codice", "Nome Filiale att", "Preamio corr", "Premio corr tass");
    for(Filiale f : listaFiliali){
      for(Cliente c : f.getListaClienti()){
        if(c.getTipoClienteString().equals("privato")){
          Privato p = (Privato) c;
          System.out.printf("%-20s %-20s %-20s %-20d %-20s %-20.2f %-20s%n", 
            p.getTipoClienteString(),
            p.getNomeCognome(),
            "-",
            p.getCodCliente(),
            f.getNome(),
            p.getPremioCorrente(),
            "-"
          );
        }else{
          Azienda a = (Azienda) c;
          System.out.printf("%-20s %-20s %-20s %-20d %-20s %-20.2f %-20.2f%n", 
            a.getTipoClienteString(),
            "-",
            a.getRagSociale(),
            a.getCodCliente(),
            f.getNome(),
            a.getPremioCorrente(),
            a.getPremioCorrTasse()
          );
        }
      }
    }
    System.out.println("----------------------------------------------------");
    Map<String,Integer> conteggioClienti = new HashMap<>();
    for(Filiale f : listaFiliali){
      for(Cliente c : f.getListaClienti()){
        conteggioClienti.put(f.getNome(), conteggioClienti.getOrDefault(f.getNome(),0) + 1);
      }
    }
    System.out.printf("%-20s %-20s%n", "Nome Filiale", "Occorrenze");
    for(Map.Entry<String, Integer> entry : conteggioClienti.entrySet()) {
      System.out.printf("%-20s %-20d%n", entry.getKey(), entry.getValue());
    }
    System.out.println("----------------------------------------------------");
  }
}
