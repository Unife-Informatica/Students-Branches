import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Prodotto> listaProdotti = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("inventario.txt"))){
            String riga;
            while ((riga=bf.readLine())!=null) { 
                if(riga.trim().isEmpty()) continue;
                String [] split = riga.split(" ");
                switch(split[0]){
                    case "toner"->{
                        String tipoProdotto=split[0];
                        int codiceProdotto=Integer.parseInt(split[1]);
                        String modello = bf.readLine();
                        String marca = bf.readLine();
                        String data = bf.readLine();
                        double prezzo = Double.parseDouble(bf.readLine());
                        String modStampante = bf.readLine();
                        List<Magazzino> listaMagazzino = new ArrayList<>();
                        while ((riga = bf.readLine()) != null && !riga.isEmpty()) { 
                            int nPezzi = Integer.parseInt(riga);
                            listaMagazzino.add(new Magazzino(nPezzi));
                        }
                        listaProdotti.add(new Toner(tipoProdotto, codiceProdotto, modello, marca, data, prezzo, modStampante, listaMagazzino));
                    }
                    case "stampante"->{
                        String tipoProdotto=split[0];
                        int codiceProdotto=Integer.parseInt(split[1]);
                        String modello = bf.readLine();
                        String marca = bf.readLine();
                        String data = bf.readLine();
                        double prezzo = Double.parseDouble(bf.readLine());
                        int peso = Integer.parseInt(bf.readLine());
                        List<Magazzino> listaMagazzino = new ArrayList<>();
                        while ((riga = bf.readLine()) != null && !riga.isEmpty()) { 
                            int nPezzi = Integer.parseInt(riga);
                            listaMagazzino.add(new Magazzino(nPezzi));
                        }
                        listaProdotti.add(new Stampante(tipoProdotto, codiceProdotto, modello, marca, data, prezzo, peso, listaMagazzino));
                    }
                    default->{
                        System.out.println("tipo di prodotto non trovato");
                    }

                }
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("Errore nel leggere il file");
        }
        System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("|%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s|%n","Tipo","Codice","Modello","Produttore","Data","Prezzo","ModelloStampante","Peso");
        for (Prodotto p : listaProdotti) {
            switch(p){
                case Toner t->{
                    System.out.printf("|%-20s %-20d %-20s %-20s %-20s %-20.2f %-20s %-20s|%n",t.getTipoProdotto(),t.getCodiceProdotto(),t.getModello(),t.getMarca(),t.getData(),t.getPrezzo(),t.getModStampante(),"-");
                }
                case Stampante s->{
                    System.out.printf("|%-20s %-20d %-20s %-20s %-20s %-20.2f %-20s %-20d|%n",s.getTipoProdotto(),s.getCodiceProdotto(),s.getModello(),s.getMarca(),s.getData(),s.getPrezzo(),"-",s.getPeso());
                }
                default->{}
            }
        }
        System.out.println(" ------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Prodotto p: listaProdotti){
            int cont=0;
            System.out.print("Modello: "+p.getModello());
            for(Magazzino m: p.getMagazzino()){
                cont+=m.getNPezzi();
            }
            System.out.println(" Quantita: " + cont);
        }
        System.out.println("-------------------------------------------------------------");
        for(Prodotto p: listaProdotti){
            float cont=0;
            float contMagazz=0;
            System.out.print("Modello: "+p.getModello());
            for(Magazzino m: p.getMagazzino()){
                contMagazz++;
                cont+=m.getNPezzi();
            }
            System.out.println(" Quantita': " + cont/contMagazz);
        }
    }
}
