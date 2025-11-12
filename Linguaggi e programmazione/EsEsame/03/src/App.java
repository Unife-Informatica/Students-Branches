import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        List<Prodotto>listaProdotti=new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("vendite.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if (riga.trim().isEmpty()) continue; // ⬅️ salta le righe vuote
                String[] split = riga.split(" ");
                switch (split[0]) {
                    case "libro" ->                         {
                            String tipoProdotto=split[0];
                            int codiceProdotto=Integer.parseInt(split[1]);
                            String titolo = bf.readLine();
                            String autore = bf.readLine();
                            int prezzo = Integer.parseInt(bf.readLine());
                            String ISBN=bf.readLine();
                            listaProdotti.add(new Libro(tipoProdotto, titolo, autore, codiceProdotto, prezzo, ISBN));
                        }
                    case "CD" ->                         {
                            String tipoProdotto=split[0];
                            int codiceProdotto=Integer.parseInt(split[1]);
                            String titolo = bf.readLine();
                            String autore = bf.readLine();
                            int prezzo = Integer.parseInt(bf.readLine());
                            int durata = Integer.parseInt(bf.readLine());
                            listaProdotti.add(new CD(tipoProdotto, titolo, autore, codiceProdotto, prezzo, durata));
                        }
                    default -> System.out.println("Tipo di prodotto non riconosciuto");
                }
                
            }
        }catch(Exception e) {
            throw new Exception("Errore nell'apertura del file");
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-10s %-10s %-30s %-30s %-10s %-15s %-10s%n","Tipo","Codice","Titolo","Autore","Prezzo","ISBN"
        ,"Durata");
        for (Prodotto p :listaProdotti) {
            switch (p) {
                case Libro l -> System.out.printf("%-10s %-10d %-30s %-30s %-10f %-15s %-10s%n",l.getTipoProdotto(),l.getCodiceProdotto(),l.getTitolo(),l.getAutore(),l.getPrezzo(),l.getISBN(), "-");
                case CD c -> System.out.printf("%-10s %-10d %-30s %-30s %-10f %-15s %-10d%n",c.getTipoProdotto(),c.getCodiceProdotto(),c.getTitolo(),c.getAutore(),c.getPrezzo(),"-", c.getDurata());
                default -> {
                }
            }
        }
        System.out.println("---------------------------------");
        Map<String, Integer> conteggiProdotti=new HashMap<>();
        for(Prodotto p:listaProdotti){
            conteggiProdotti.put(p.getAutore(),conteggiProdotti.getOrDefault(p.getAutore(),0)+1);
        }
        System.out.printf("%-30s %-10s%n","Autore","Occorrenze");
        for (Map.Entry<String,Integer> entry: conteggiProdotti.entrySet()) {
            System.out.printf("%-30s %-10s%n",entry.getKey(),entry.getValue());
        }
        System.out.println("---------------------------------");
        double prezzoMedio=0;
        int cont=0;
        for(Prodotto p:listaProdotti){
            prezzoMedio+=p.getPrezzo();
            cont++;
        }
        System.out.println("Prezzo medio:"+prezzoMedio/cont);

    }
}
