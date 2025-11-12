
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Impiegato> listaImpiegati = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("impiegati.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                String[] split = riga.split(" ");
                int codImpiegato = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "sommelier"->{
                        String tipoImpiegato = split[1];
                        String nomeCognome = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        int oreSettimanali = Integer.parseInt(split[0]);
                        double costOrario = Double.parseDouble(split[1]);
                        String specialita = bf.readLine();
                        listaImpiegati.add(new Sommelier(codImpiegato, tipoImpiegato, nomeCognome, oreSettimanali, costOrario, specialita));
                    }
                    case "guida"->{
                        String tipoImpiegato = split[1];
                        String nomeCognome = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        String numTel = split[0];
                        boolean sEnglish = Boolean.parseBoolean(split[1]);
                        int appSett = Integer.parseInt(split[2]);
                        double costOrario = Double.parseDouble(split[3]);
                        listaImpiegati.add(new Guida(codImpiegato, tipoImpiegato, nomeCognome, numTel, sEnglish, appSett, costOrario));
                    }
                    default->{
                        System.out.println("Tipo di impiegato non trovato");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int maxLen=20;
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Nome","Codice","Tipo","Ore settimanli","Specialita'","Telefono","Inglese","App. sett.","Costo Orario");
        for(Impiegato i:listaImpiegati){
            switch(i){
                case Sommelier s->{
                    System.out.printf("%-20s %-20d %-20s %-20d %-20s %-20s %-20s %-20s %-20.2f%n",
                        truncate(s.getNomeCognome(),maxLen),
                        s.getCodImpiegato(),
                        truncate(s.getTipoImpiegato(), maxLen),
                        s.getOreSettimanali(),
                        truncate(s.getSpecialita(),maxLen),
                        "-",
                        "-",
                        "-",
                        s.getCostOrario()
                    );
                }
                case Guida g->{
                    System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20s %-20b %-20d %-20.2f%n",
                        truncate(g.getNomeCognome(),maxLen),
                        g.getCodImpiegato(),
                        truncate(g.getTipoImpiegato(), maxLen),
                        "-",
                        "-",
                        truncate(g.getNumTel(), maxLen),
                        g.issEnglish(),
                        g.getAppSett(),
                        g.getCostOrario()
                    );
                }
                default->{}
            }
        }
        System.out.println("-----------------------------------\n");
        /* Lettura file visitatori.txt */
        List<Visitatore> listaVisitatori = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("visitatori.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                int codVisistatore = Integer.parseInt(riga);
                String nomeCognome = bf.readLine();
                List<Servizio> listaServizi =new ArrayList<>();
                while((riga=bf.readLine())!=null && !riga.trim().isEmpty()){
                    String[] split = riga.split(" ");
                    int codImpiegato = Integer.parseInt(split[0]);
                    double oreServizio = Double.parseDouble(split[1]);
                    listaServizi.add(new Servizio(codImpiegato, oreServizio));

                }
                listaVisitatori.add(new Visitatore(codVisistatore, nomeCognome, listaServizi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Parte 4 dell'esercizio */
        for(Visitatore v: listaVisitatori){
            System.out.printf("Num: %-20d Nome: %-20s%n",v.getCodVisistatore(),truncate(v.getNomeCognome(),maxLen));
            for(Servizio s:v.getListaServizi()){
                for(Impiegato i: listaImpiegati){
                    if(s.getCodImpiegato()==i.getCodImpiegato()){
                        System.out.printf(" %-20s %-20.2f %.2f$%n",truncate(i.getNomeCognome(), maxLen),s.getOreServizio(),i.getCostOrario()*s.getOreServizio());
                        System.out.println("");
                    }
                }
            }
        }
    }
    public static String truncate(String s, int maxLen){
        if(s==null) return "-";
        return(s.length()>maxLen)?s.substring(0,maxLen-3)+"...":s;
    }
}
