import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /* Lettura Dipendenti */
        List<Dipendente> listaDipendenti = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("dipendenti.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if (riga.trim().isEmpty()) continue;
                String[] split = riga.split(" ");
                int codDipendente = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "trainer"->{
                        String tipoDipendente = split[1];
                        String nomeDipendente = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        int oreSettimanali = Integer.parseInt(split[0]);
                        double costoOrario = Double.parseDouble(split[1]);
                        String specialita = bf.readLine();
                        listaDipendenti.add(new Trainer(codDipendente, tipoDipendente, nomeDipendente, oreSettimanali, costoOrario, specialita));
                    }
                    case "nutrizionista"->{
                        String tipoDipendente = split[1];
                        String nomeDipendente = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        String telefono = split[0];
                        boolean medico = Boolean.parseBoolean(split[1]);
                        int appSett = Integer.parseInt(split[2]);
                        double costoOrario = Double.parseDouble(split[3]);
                        listaDipendenti.add(new Nutrizionista(codDipendente, tipoDipendente, nomeDipendente, telefono, medico, appSett, costoOrario));
                    }
                    default->{System.out.println("Tipo di dipendente non trovato");}
                }
            }
        } catch (Exception e) {
            System.out.println("Errore nella lettura del file dipendenti.txt");
        }
        System.out.println("--------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Nome","Codice","Tipo","Ore sett.","Specialita","Telefono","Medico","App. sett.","Costo Orario");
        int maxLen = 20;
        for(Dipendente d:listaDipendenti){
            switch(d){
                case Trainer t->{
                    System.out.printf("%-20s %-20d %-20s %-20d %-20s %-20s %-20s %-20s %-20s%n",
                        truncate(t.getNomeDipendente(), maxLen),
                        t.getCodDipendente(),
                        truncate(t.getTipoDipendente(), maxLen),
                        t.getOreSettimanali(),
                        truncate(t.getSpecialita(), maxLen),
                        "-",
                        "-",
                        "-",
                        t.getCosto()
                    );
                }
                case Nutrizionista n->{
                    System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20s %-20b %-20s %-20s%n",
                        truncate(n.getNomeDipendente(), maxLen),
                        n.getCodDipendente(),
                        truncate(n.getTipoDipendente(), maxLen),
                        "-",
                        "-",
                        truncate(n.getTelefono(), maxLen),
                        n.isMedico(),
                        n.getAppSett(),
                        n.getCosto()
                    );
                }
                default->{/* Nessuna azione richiesta */}
            }
        }
        System.out.println("--------------------------------------------");
        /* Lettura clienti */
        List<Cliente> listaClienti = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("clienti.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                int codiceCliente = Integer.parseInt(riga);
                String nomeCliente = bf.readLine();
                List<Servizio> listaServizi = new ArrayList<>();
                while((riga=bf.readLine())!=null&&!riga.trim().isEmpty()){
                    String[] split = riga.split(" ");
                    int codiceDipendente = Integer.parseInt(split[0]);
                    double oreServizio = Double.parseDouble(split[1]);
                    listaServizi.add(new Servizio(codiceDipendente, oreServizio));
                }
                listaClienti.add(new Cliente(codiceCliente, nomeCliente, listaServizi));
            }
        } catch (Exception e) {
            System.out.println("Errore nella lettura del file clienti.txt");
        }
        System.out.printf("%-20s %-20s %-20s%n","Codice","Nome","Costo totale");
        Map<Integer,Double> mappaCosto = new HashMap<>();
        for(Dipendente d:listaDipendenti){
            mappaCosto.put(d.getCodDipendente(), d.getCosto());
        }
        for(Cliente c: listaClienti){
            double prezzoTot=0;
            for(Servizio s: c.getListaServizi()){
                prezzoTot+=s.getOreServizio()*mappaCosto.getOrDefault(s.getCodiceDipendente(), 0.0);
            }
            System.out.printf("%-20d %-20s %-20.2f%n", c.getCodiceCliente(),truncate(c.getNomeCliente(), maxLen),prezzoTot);
        }
        System.out.println("--------------------------------------------");
        // 4. Dipendente con il maggior numero di servizi
        Map<Integer, Integer> serviziPerDipendente = new HashMap<>();
        for(Cliente c:listaClienti){
            for(Servizio s:c.getListaServizi()){
                int codiceDipendente = s.getCodiceDipendente();
                serviziPerDipendente.put(codiceDipendente, serviziPerDipendente.getOrDefault(codiceDipendente, 0)+1);
            }
        }
        int codiceMax = -1;
        int maxServizi = 0;
        for(Map.Entry<Integer,Integer> entry: serviziPerDipendente.entrySet()){
            if(entry.getKey()>codiceMax){
                codiceMax=entry.getKey();
                maxServizi = entry.getValue();
            }
        }
        for(Dipendente d:listaDipendenti){
            if(d.getCodDipendente()==codiceMax){
                System.out.println("Il dipendente con piu' servizi e': "+d.getNomeDipendente()+" ("+maxServizi+" servizi)");
            }
        }


    }
    public static String truncate(String s, int maxLen){
        if(s==null) return "";
        return (s.length()>maxLen)?s.substring(0,maxLen-3)+"...":s;
    }
}
