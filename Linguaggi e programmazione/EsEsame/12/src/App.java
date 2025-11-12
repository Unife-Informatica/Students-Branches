
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Evento> listaEventi = new ArrayList<>();
        int maxLen = 20;
        try(BufferedReader bf = new BufferedReader(new FileReader("eventi.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String nomeEvento = riga;
                riga=bf.readLine();
                String[] split = riga.split(" ");
                int codEvento = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "partita"->{
                        String tipoEvento = split[1];
                        int posti = Integer.parseInt(split[2]);
                        String sport = bf.readLine();
                        String strutOspit = bf.readLine();
                        String data = bf.readLine();
                        float prezzo = Float.parseFloat(bf.readLine());
                        listaEventi.add(new Partita(nomeEvento, codEvento, tipoEvento, posti, strutOspit, data, prezzo, sport));
                    }
                    case "concerto"->{
                        String tipoEvento = split[1];
                        int posti = Integer.parseInt(split[2]);
                        int durata = Integer.parseInt(bf.readLine());
                        String strutOspit = bf.readLine();
                        String data = bf.readLine();
                        float prezzo = Float.parseFloat(bf.readLine());
                        listaEventi.add(new Concerto(nomeEvento, codEvento, tipoEvento, posti, strutOspit, data, prezzo, durata));
                    }
                    default->{
                        System.out.println("Tipo di evento non trovato");
                    }
                }
            }
        }catch(Exception e){
            throw new Exception("Errore nella lettura del file eventi.txt");
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Tipo","Nome","Codice","Struttura","Data","Prezzo","Numero posti","Durata","Sport");
        for(Evento e:listaEventi){
            switch(e){
                case Partita p->{
                    System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20.2f %-20d %-20s %-20s%n",
                        truncate(p.getTipoEvento(), maxLen),
                        truncate(p.getNomeEvento(), maxLen),
                        p.getCodEvento(),
                        truncate(p.getStrutOspit(), maxLen),
                        truncate(p.getData(),maxLen),
                        p.getPrezzo(),
                        p.getPosti(),
                        "-",
                        truncate(p.getSport(), maxLen)
                    );
                }
                case Concerto c->{
                    System.out.printf("%-20s %-20s %-20d %-20s %-20s %-20.2f %-20d %-20s %-20s%n",
                        truncate(c.getTipoEvento(), maxLen),
                        truncate(c.getNomeEvento(), maxLen),
                        c.getCodEvento(),
                        truncate(c.getStrutOspit(), maxLen),
                        truncate(c.getData(),maxLen),
                        c.getPrezzo(),
                        c.getPosti(),
                        c.getDurata(),
                        "-"
                    );
                }
                default->{/* Nessuna azione richiesta */}
            }
        }
        System.out.println("----------------------------------------");
        /* Lettura file prenotazioni  */
        List<Prenotazione> listaPrenotazioni = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("prenotazioni.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String[] split = riga.split(" ");
                int codEvento = Integer.parseInt(split[0]);
                String nome = split[1];
                String cognome = split[2];
                int postoAssegnato = Integer.parseInt(split[3]);
                boolean dipendente = Boolean.parseBoolean(split[4]);
                listaPrenotazioni.add(new Prenotazione(codEvento,postoAssegnato,nome,cognome,dipendente));
            }
        } catch (Exception e) {
            System.err.println("Errore nella lettura del file prenotazioni.txt");
             e.printStackTrace();  // stampa il dettaglio tecnico dell’errore
        }
        /* Stampa evento con incasso */
        System.out.printf("%-20s %-20s%n","Nome evento", "Incassi totali");
        for(Evento e: listaEventi){
            System.out.printf("%-20s ", truncate(e.getNomeEvento(),maxLen));
            float prezzoTotale=0;
            int cont=0;
            for(Prenotazione p:listaPrenotazioni){
                if(e.getCodEvento()==p.getCodEvento()){
                    cont++;
                }
            }
            prezzoTotale=cont*e.getPrezzo();
            System.out.printf("%-20.2f%n",prezzoTotale);
            System.out.println("");
        }
        for(Evento e: listaEventi)
    }
    public static String truncate(String s, int maxLen){
        if(s==null) return "-";
        return(s.length()>maxLen)?s.substring(0,maxLen-3)+"...":s;
    }
}
