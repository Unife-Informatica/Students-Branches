import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        List<Appello> listaAppelli=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader("appelli.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String[] split = riga.split(" ");
                switch(split[0]){
                    case "scritto"->{
                        String tipoAppello = split[0];
                        int codiceAppello = Integer.parseInt(split[1]);
                        String docente = bf.readLine();
                        String corso = bf.readLine();
                        String data = bf.readLine();
                        int orario = Integer.parseInt(bf.readLine());
                        String aula = bf.readLine();
                        int durata = Integer.parseInt(bf.readLine());
                        listaAppelli.add(new Scritti(tipoAppello, codiceAppello, docente, corso, data, orario, aula, durata));
                    }
                    case "orale"->{
                        String tipoAppello = split[0];
                        int codiceAppello = Integer.parseInt(split[1]);
                        String docente = bf.readLine();
                        String corso = bf.readLine();
                        String data = bf.readLine();
                        int orario = Integer.parseInt(bf.readLine());
                        int maxStudenti = Integer.parseInt(bf.readLine());
                        listaAppelli.add(new Orali(tipoAppello, codiceAppello, docente, corso, data, orario, maxStudenti));
                    }
                    default->{
                        System.out.println("Tipo di Appello non trovato");
                    }
                }

            }
        } catch (Exception e) {
            e.getStackTrace();
            throw new Exception("Impossibile aprire il file");
        }
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Tipo","Codice","Professore","Corso","Data","Ora","Aula","Durata","StudentiMax");
        for(Appello a : listaAppelli){
            switch(a){
                case Scritti s->{
                    System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20d %-20s %-20d %-20s%n",
                            truncate(s.getTipoAppello(), 20),
                            s.getCodiceAppello(),
                            truncate(s.getDocente(), 20),
                            truncate(s.getCorso(), 20),
                            truncate(s.getData(), 20),
                            s.getOrario(),
                            truncate(s.getAula(), 20),
                            s.getDurata(),
                            "-");
                }
                case Orali o->{
                    System.out.printf("%-20s %-20d %-20s %-20s %-20s %-20d %-20s %-20s %-20d%n",
                    truncate(o.getTipoAppello(), 20),
                    o.getCodiceAppello(),
                    truncate(o.getDocente(), 20),
                    truncate(o.getCorso(), 20),
                    truncate(o.getData(), 20),
                    o.getOrario(),
                    "-", // Aula non definita
                    "-", // Durata non definita
                    o.getMaxStudenti());
                }
                default->{}
            }
        }
        System.out.println("-------------------------------------------");
        Map<String,Integer> conteggiDocenti = new HashMap<>();
        for(Appello a:listaAppelli)
            conteggiDocenti.put(a.getDocente(),conteggiDocenti.getOrDefault(a.getDocente(), 0)+1);
        System.out.printf("%-20s %-20s%n","Docente","Occorrenze");
        for(Map.Entry<String,Integer> entry:conteggiDocenti.entrySet())
            System.out.printf("%-20s %-20d%n",
                truncate(entry.getKey(), 20),
                entry.getValue()
            );
        System.out.println("-------------------------------------------");
        
    }
    public static String truncate(String s, int maxLen) {
        if (s == null) return "-";
        return (s.length() > maxLen) ? s.substring(0, maxLen - 3) + "..." : s;
    }
}
