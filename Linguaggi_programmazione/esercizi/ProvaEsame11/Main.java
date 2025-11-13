import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Iscritto> listaIscritti = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("iscritti.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        if(riga.trim().isEmpty()) continue;

        String[] split;
        String nomeCognome = riga;
        riga = reader.readLine();
        split = riga.split(" ");
        int codiceIscritto = Integer.parseInt(split[0]);
        String tipo = split[1];

        if(tipo.equals("docente")){
          int eta = Integer.parseInt(split[2]);
          riga = reader.readLine();
          String corsoPrincipale = riga;
          riga = reader.readLine();
          String indirizzo = riga;

          List<Integer> listaContatti = new ArrayList<>();
          try(BufferedReader readerDocente = new BufferedReader(new FileReader("contatti.txt"))){
            while((riga = readerDocente.readLine()) != null) {
              split = riga.split(" ");
              int codiceIscrittoCont = Integer.parseInt(split[0]);
              if(codiceIscrittoCont == codiceIscritto){
                for(int i = 1; i < split.length; i++){
                  int num = Integer.parseInt(split[i]);
                  listaContatti.add(num);
                }
                break;
              }
            }
          }catch(IOException e){
            e.printStackTrace();
          }
          listaIscritti.add(new Docente(nomeCognome, tipo, indirizzo, codiceIscritto, eta, new Contatto(codiceIscritto, listaContatti), corsoPrincipale));
        }else{
          int eta = Integer.parseInt(split[2]);
          riga = reader.readLine();
          float votoMedio = Float.parseFloat(riga);
          riga = reader.readLine();
          String indirizzo = riga;

          List<Integer> listaContatti = new ArrayList<>();
          try(BufferedReader readerStudente = new BufferedReader(new FileReader("contatti.txt"))){
            while((riga = readerStudente.readLine()) != null) {
              split = riga.split(" ");
              int codiceIscrittoCont = Integer.parseInt(split[0]);
              if(codiceIscrittoCont == codiceIscritto){
                for(int i = 1; i < split.length; i++){
                  int num = Integer.parseInt(split[i]);
                  listaContatti.add(num);
                }
                break;
              }
            }
          }catch(IOException e){
            e.printStackTrace();
          }
          listaIscritti.add(new Studente(nomeCognome, tipo, indirizzo, codiceIscritto, eta, new Contatto(codiceIscritto, listaContatti), votoMedio));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }
    System.out.println("-------------------------------------------------");
    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n", "Tipo", "Nome e cognome", "Codice", "Età", "Corso Princ", "Media", "Indirizzo");
    for(Iscritto i : listaIscritti){
      if(i.getTipoIscritto().equals("docente")){
        System.out.printf("%-20s %-20s %-20d %-20d %-20s %-20s %-20s%n", 
        i.getTipoIscritto(),
        i.getNomeCognome(),
        i.getCodiceIscritto(),
        i.getEta(),
        i.getDettaglio(),
        "-",
        i.getIndirizzo()
      );
      }else{
        System.out.printf("%-20s %-20s %-20d %-20d %-20s %-20.2f %-20s%n",
          i.getTipoIscritto(),
          i.getNomeCognome(),
          i.getCodiceIscritto(),
          i.getEta(),
          "-",
          Float.parseFloat(i.getDettaglio()),
          i.getIndirizzo()
        );
      }
    }
    System.out.println("-------------------------------------------------");
    for(Iscritto i : listaIscritti){
      if(i instanceof Docente){
        List<Integer> contatti = i.getContatto().getListaCodici();

        int sommaEta = 0;
        int cont = 0;

        for(int codiceCont : contatti){
          for(Iscritto x : listaIscritti){
            if(x.getCodiceIscritto() == codiceCont){
              sommaEta+=x.getEta();
              cont++;
              break;
            }
          }
        }

        if (cont > 0) {
          double media = (double) sommaEta / cont;
          System.out.printf("%-25s → Media età contatti: %.2f%n", i.getNomeCognome(), media);
        }else{
          System.out.printf("%-25s → Nessun contatto collegato%n", i.getNomeCognome());
        }
      }
    }
    System.out.println("-------------------------------------------------");
    for(Iscritto i : listaIscritti){
      if(i instanceof Studente){
        List<Integer> contatti = i.getContatto().getListaCodici();

        int sommaEta = 0;
        int cont = 0;

        for(int codiceCont : contatti){
          for(Iscritto x : listaIscritti){
            if(x.getCodiceIscritto() == codiceCont){
              sommaEta+=x.getEta();
              cont++;
              break;
            }
          }
        }

        if (cont > 0) {
          double media = (double) sommaEta / cont;
          System.out.printf("%-25s → Media età contatti: %.2f%n", i.getNomeCognome(), media);
        }else{
          System.out.printf("%-25s → Nessun contatto collegato%n", i.getNomeCognome());
        }
      }
    }
  }
}
