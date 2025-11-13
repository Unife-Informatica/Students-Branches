import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<Dipendente> listaDipendenti = new ArrayList<>();
    try(BufferedReader reader = new BufferedReader(new FileReader("dipendenti.txt"))){
      String riga;
      while((riga = reader.readLine()) != null){
        String[] split;
        if(riga.trim().isEmpty()) continue;
        split = riga.split(" ");
        int codiceDip = Integer.parseInt(split[0]);
        String tipoDip = split[1];
        riga = reader.readLine();
        String nomeDip = riga;
        if(tipoDip.equals("trainer")){
          riga = reader.readLine();
          split = riga.split(" ");
          int oreSett = Integer.parseInt(split[0]);
          double costoOrarioTrainer = Double.parseDouble(split[1]);
          riga = reader.readLine();
          String specialita = riga;
          listaDipendenti.add(new Trainer(codiceDip, tipoDip, nomeDip, oreSett, costoOrarioTrainer, specialita));
        }else{
          riga = reader.readLine();
          split = riga.split(" ");
          long telefono = Long.parseLong(split[0]);
          boolean medico = Boolean.parseBoolean(split[1]);
          int appuntamentiSett = Integer.parseInt(split[2]);
          double costoOrarioNutriz = Double.parseDouble(split[3]);
          listaDipendenti.add(new Nutrizionista(codiceDip, tipoDip, nomeDip, telefono, medico, appuntamentiSett, costoOrarioNutriz));
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    List<Cliente> listaClienti = new ArrayList<>();
    try(BufferedReader reader2 = new BufferedReader(new FileReader("clienti.txt"))){
      String riga;
      while((riga = reader2.readLine()) != null){
        String[] split;
        if(riga.trim().isEmpty())continue;
        int codiceCliente = Integer.parseInt(riga);
        riga = reader2.readLine();
        String nomeCliente = riga;
        List<Servizio> listaServizi = new ArrayList<>();
        while((riga = reader2.readLine()) != null && !riga.trim().isEmpty()){
          split = riga.split(" ");
          int codiceDip = Integer.parseInt(split[0]);
          double nOreServizio = Double.parseDouble(split[1]);
          listaServizi.add(new Servizio(codiceDip, nOreServizio));
        }
        listaClienti.add(new Cliente(codiceCliente, nomeCliente, listaServizi));
      }
    }catch(IOException e){
      e.printStackTrace();
    }

    System.out.println("----------------------------------------------------------------");
    System.out.printf("%-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s %-18s%n", "Nome", "Cod", "Tipo", "Ore Sett.", "Spec.", "Tel.", "Medico", "App.Sett", "Costo Or.");
    for(Dipendente d : listaDipendenti){
      if(d.getTipoDip().equals("trainer")){
        Trainer t = (Trainer) d;
        System.out.printf("%-18s %-18d %-18s %-18d %-18s %-18s %-18s %-18s %-18.2f%n", 
          t.getNomeDip(),
          t.getCodiceDip(),
          t.getTipoDip(),
          t.getOreSett(),
          t.getSpecialita(),
          "-",
          "-",
          "-",
          t.getCostoOrarioTrainer()
        );
      }else{
        Nutrizionista n = (Nutrizionista) d;
        System.out.printf("%-18s %-18d %-18s %-18s %-18s %-18d %-18b %-18d %-18.2f%n", 
          n.getNomeDip(),
          n.getCodiceDip(),
          n.getTipoDip(),
          "-",
          "-",
          n.getTelefono(),
          n.isMedico(),
          n.getAppuntamentiSett(),
          n.getCostoOrarioNutriz()
        );
      }
    }
    System.out.println("----------------------------------------------------------------");

    System.out.printf("%-18s %-18s %-18s%n", "Codice", "Nome", "Totale Serv.");
    for(Cliente c : listaClienti){
      double costoTotServ = 0;
      for(Servizio s : c.getListaServizi()){
        double costoSingoliServ = 0.0;
        for(Dipendente d : listaDipendenti){
          if(d.getCodiceDip() == s.getCodiceDip()){
            if(d.getTipoDip().equals("trainer")){
              Trainer t = (Trainer) d;
              costoSingoliServ=s.getnOreServizio()*t.getCostoOrarioTrainer();
            }else{
              Nutrizionista n = (Nutrizionista) d;
              costoSingoliServ=s.getnOreServizio()*n.getCostoOrarioNutriz();
            }
          }
        }
        costoTotServ+=costoSingoliServ;
      }
      System.out.printf("%-18d %-18s %-18.2f%n", 
        c.getCodiceCliente(),
        c.getNomeCliente(),
        costoTotServ
      );
    }
    System.out.println("----------------------------------------------------------------");
    System.out.printf("%-18s %-18s%n", "Nome", "N° Serv.");
    Map<Integer, Integer> contatoreServizi = new HashMap<>();

    for (Cliente c : listaClienti) {
      for (Servizio s : c.getListaServizi()) {
        int codiceDip = s.getCodiceDip();
        contatoreServizi.put(codiceDip, contatoreServizi.getOrDefault(codiceDip, 0) + 1);
      }
    }

    int codiceMax = -1;
    int maxServizi = 0;
    for (Map.Entry<Integer, Integer> entry : contatoreServizi.entrySet()) {
      if (entry.getValue() > maxServizi) {
        maxServizi = entry.getValue();
        codiceMax = entry.getKey();
      }
    }

    for (Dipendente d : listaDipendenti) {
      if (d.getCodiceDip() == codiceMax) {
        System.out.printf("%-18s %-18d%n", d.getNomeDip(), maxServizi);
        break;
      }
    }
    System.out.println("----------------------------------------------------------------");
  }
}
