import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Partita> listaPartite = new ArrayList<>(); 
        try(BufferedReader bf = new BufferedReader(new FileReader("partite.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                String[] split=riga.split(" ");
                switch(split[0].charAt(0)){
                    case 'c'->{
                        char tipoPartita=split[0].charAt(0);
                        String palazzetto=split[1];
                        String data = split[2];
                        String orario = split[3];
                        String punteggi = split[4];
                        int vittoria = Integer.parseInt(split[5]) ;
                        listaPartite.add(new Casa(tipoPartita, data, orario, punteggi, vittoria, palazzetto));
                    }
                    case 'f'->{
                        char tipoPartita=split[0].charAt(0);
                        String cittaOspitante = split[1];
                        String data = split[2];
                        String orario = split[3];
                        String punteggi = split[4];
                        int vittoria = Integer.parseInt(split[5]) ;
                        listaPartite.add(new FuoriCasa(tipoPartita, data, orario, punteggi, vittoria, cittaOspitante));
                    } 
                    default->{
                        System.out.println("Tipo di partita non trovato");
                    }

                }
            }
        } catch (Exception e) {
            e.getStackTrace();
            throw new Exception("Errore nell'apertura del file");
        }
        System.out.println("---------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s%n","Palazzetto","Citta","Data","Ora","Punteggi");
        for(Partita p:listaPartite){
            switch(p){
                case Casa c->{
                    int maxLength=20;
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s%n",
                        truncate(c.getPalazzetto(), 20),
                        "-",
                        truncate(c.getData(), 20),
                        truncate(c.getOrario(), maxLength),
                        truncate(c.getPunteggi(), maxLength)
                    );
                }
                case FuoriCasa f->{
                    int maxLength=20;
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s%n",
                        "-",
                        truncate(f.getCittaOspitante(), 20),
                        truncate(f.getData(), 20),
                        truncate(f.getOrario(), maxLength),
                        truncate(f.getPunteggi(), maxLength)
                    );
                }
                default->{}
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Partite vinte in casa");
        for(Partita p:listaPartite){
            switch(p){
                case Casa c->{
                    if(c.getVittoria()==1){
                        int maxLength=20;
                        System.out.printf("%-20s %-20s %-20s %-20s%n",
                        truncate(c.getPalazzetto(), 20),
                        truncate(c.getData(), 20),
                        truncate(c.getOrario(), maxLength),
                        truncate(c.getPunteggi(), maxLength)
                        );
                    }
                }
                default->{}
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Partite vinte fuori casa");
        for(Partita p:listaPartite){
            switch(p){
                case FuoriCasa f->{
                    if(f.getVittoria()==1){
                        int maxLength=20;
                        System.out.printf("%-20s %-20s %-20s %-20s%n",
                        truncate(f.getCittaOspitante(), 20),
                        truncate(f.getData(), 20),
                        truncate(f.getOrario(), maxLength),
                        truncate(f.getPunteggi(), maxLength)
                        );
                    }
                }
                default->{}
            }
        }
        String cittaConfronto;
        Scanner obj = new Scanner(System.in);
        System.out.println("Inserisci il nome della citta':");
        cittaConfronto=obj.nextLine();
        System.out.print("\033[1A"); // sposta il cursore su una riga sopra
        System.out.print("\033[2K"); // cancella l’intera riga
        System.out.flush();
        boolean notFind=false;
        for(Partita p:listaPartite){
            switch(p){
                case FuoriCasa f->{
                    if(f.getCittaOspitante().equalsIgnoreCase(cittaConfronto)){
                        int maxLength=20;
                        System.out.printf("%-20s %-20s %-20s %-20s%n",
                        truncate(f.getCittaOspitante(), 20),
                        truncate(f.getData(), 20),
                        truncate(f.getOrario(), maxLength),
                        truncate(f.getPunteggi(), maxLength)
                        );
                        notFind = true;
                    }
                    
                }
                case Casa c->{/*nessuna azione richiesta*/}
                default->{/*nessuna azione richiesta*/}
            }
            
        }
        if(!notFind){
            System.out.println("Partita a: "+cittaConfronto+" non ancora giocata");
        }
    }
    public static String truncate(String s,int maxLength){
        if(s==null) return "-";
        return (s.length()>maxLength) ? s.substring(0,maxLength-3)+"...":s;
    }
}
