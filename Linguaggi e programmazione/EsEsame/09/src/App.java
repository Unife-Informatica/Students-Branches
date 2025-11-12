import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Squadra> listaSquadre = new ArrayList<>();
        List<Giocatore> listaGiocatori = new ArrayList<>();
        int maxLen = 20;
        /* Lettura Squadre  */
        try(BufferedReader bf = new BufferedReader(new FileReader("squadre.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                String nomeSquadra = riga;
                riga=bf.readLine();
                String[] split = riga.split(" ");
                int codiceSquadra = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "pallavolo"->{
                        String tipoSport = split[1];
                        riga=bf.readLine();
                        split = riga.split(" ");
                        int pVinte = Integer.parseInt(split[0]);
                        int pPerse = Integer.parseInt(split[1]);
                        float mSetV = Float.parseFloat(split[2]);
                        listaSquadre.add(new Pallavolo(nomeSquadra, tipoSport, codiceSquadra, pVinte, pPerse, mSetV));
                    }
                    case "basket"->{
                        String tipoSport = split[1];
                        riga=bf.readLine();
                        split = riga.split(" ");
                        int pVinte = Integer.parseInt(split[0]);
                        int pPerse = Integer.parseInt(split[1]);
                        float pMedio = Float.parseFloat(split[2]);
                        listaSquadre.add(new Basket(nomeSquadra, tipoSport, codiceSquadra, pVinte, pPerse, pMedio));
                    }
                    default->{
                        System.out.println("Sport non presente");
                    }
                }

                
            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Errore nell'apertura del file squadre.txt");
        }
        System.out.println("------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Nome della Squadra","Codice", "n.Partite vinte","n.Partite perse","Punteggio medio","n.Medio set vinti","sport");
        for(Squadra s:listaSquadre){
            switch(s){
                case Pallavolo p->{
                    System.out.printf("%-20s %-20d %-20d %-20d %-20s %-20.2f %-20s%n",
                        truncate(p.getNomeSquadra(), maxLen),
                        p.getCodiceSquadra(),
                        p.getnVinte(),
                        p.getnPerse(),
                        "-",
                        p.getmSetV(),
                        p.getTipoSport()
                    );
                }
                case Basket b->{
                    System.out.printf("%-20s %-20d %-20d %-20d %-20.2f %-20s %-20s%n",
                        truncate(b.getNomeSquadra(), maxLen),
                        b.getCodiceSquadra(),
                        b.getnVinte(),
                        b.getnPerse(),
                        b.getpMedio(),
                        "-",
                        b.getTipoSport()
                    );
                }
                default->{}
            }
        }
        System.out.println("------------------------------------");
        /* Lettura Giocatori */
        try(BufferedReader bf = new BufferedReader(new FileReader("giocatori.txt"))){
            String riga;
            while((riga=bf.readLine())!=null && !riga.trim().isEmpty()){
                String[] split = riga.split(" ");
                int codiceSquadra = Integer.parseInt(split[0]);
                String cognome = split[1];
                int eta = Integer.parseInt(split[2]);
                int numeroM = Integer.parseInt(split[3]);
                String ruolo = split[4];
                String titolare = split[5];
                listaGiocatori.add(new Giocatore(cognome, ruolo, codiceSquadra, eta, numeroM, titolare));
            }
        }catch(Exception e){
            e.getStackTrace();
            System.out.println("Errore nella lettuara del file giocatori.txt");
        }
        for(Squadra s:listaSquadre){
            int nGiocatori=0;
            System.out.println(s.getNomeSquadra());
            for(Giocatore g:listaGiocatori){
                if(s.getCodiceSquadra()==g.getCodiceSquadra()){
                    nGiocatori++;
                }
            }
            System.out.println("Numero di giocatori: "+nGiocatori);
            System.out.println("-------------------------------");

        }
        /* Ricerca giocatori di una squadra*/
        Scanner obj = new Scanner(System.in);
        System.out.println("Ricerca giocatori\n|Inserire nome della squadra: |");
        String nomeSquadra = obj.nextLine();
        boolean find = false;
        for(Squadra s:listaSquadre){
            if(nomeSquadra.equalsIgnoreCase(s.getNomeSquadra())){
                System.out.printf("%-20s %-20s %-20s %-20s %-20s%n","Cognome","Eta'","Numero maglia","Ruolo","Titolare");
                for(Giocatore g:listaGiocatori){
                    if(s.getCodiceSquadra()==g.getCodiceSquadra()){
                        System.out.printf("%-20s %-20d %-20d %-20s %-20s%n",
                            truncate(g.getCognome(), maxLen),
                            g.getEta(),
                            g.getNumMaglia(),
                            truncate(g.getRuolo(), maxLen),
                            truncate(g.isTitolare(), maxLen)
                        );
                        find = true;
                    }
                }
            }
        }
        if(!find){
            System.out.println("Squadra non trovata");
        }
    }
    public static String truncate(String s,int maxLen){
        if(s==null)return "-";
        return(s.length()>maxLen)?s.substring(0,maxLen-3)+"...":s;
    }
}
