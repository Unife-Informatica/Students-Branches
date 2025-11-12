import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Squadra> listaSquadre = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("squadra.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                String nomeSquadra = riga;
                riga = bf.readLine();
                String[] split = riga.split(" ");
                int codice = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "pallavolo"->{
                        String tipoSport = split[1];
                        riga = bf.readLine();
                        split = riga.split(" ");
                        int nPartiteVinte = Integer.parseInt(split[0]);
                        int nPartitePerse = Integer.parseInt(split[1]);
                        float nMedioSetVinti = Float.parseFloat(split[2]);
                        listaSquadre.add(new Pallavolo(nomeSquadra, codice, tipoSport, nPartiteVinte, nPartitePerse, nMedioSetVinti));
                    }
                    case "basket"->{
                        String tipoSport = split[1];
                        riga = bf.readLine();
                        split = riga.split(" ");
                        int nPartiteVinte = Integer.parseInt(split[0]);
                        int nPartitePerse = Integer.parseInt(split[1]);
                        float punteggioMedio = Float.parseFloat(split[2]);
                        listaSquadre.add(new Basket(nomeSquadra, codice, tipoSport, nPartiteVinte, nPartitePerse, punteggioMedio));
                    }
                    default->{
                        System.out.println("Tipo di sport non trovato");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
            "Nome S.", "Codice", "P. Vinte", "P. Perse", "P. Medio", "n. Set Vinti", "Sport"
        );
        for(Squadra s:listaSquadre){
            switch(s){
                case Pallavolo p->{
                    System.out.printf("%-20s %-20d %-20d %-20d %-20s %-20f %-20s%n",
                        p.getNomeSquadra(),
                        p.getCodice(),
                        p.getNPartiteVinte(),
                        p.getNPartitePerse(),
                        "-",
                        p.getNMedioSetVinti(),
                        p.getTipoSport()
                    );
                }
                case Basket b->{
                    System.out.printf("%-20s %-20d %-20d %-20d %-20f %-20s %-20s%n",
                        b.getNomeSquadra(),
                        b.getCodice(),
                        b.getNPartiteVinte(),
                        b.getNPartitePerse(),
                        b.getPunteggioMedio(),
                        "-",
                        b.getTipoSport()
                    );
                }
                default->{}
            }
        }
    }
}
