import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Transazione> listaTransazioni = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("transazioni.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String[] split = riga.split(" ");
                switch(split[0]){
                    case "privato"->{
                        String tipoTransazione = split[0];
                        int codiceTransazione = Integer.parseInt(split[1]);
                        String data = bf.readLine();
                        String nomeCognome = bf.readLine();
                        String indirizzo = bf.readLine();
                        String CF = bf.readLine();
                        List<Prodotto> listaProdotti = new ArrayList<>();
                        while((riga=bf.readLine())!=null&&!riga.trim().isEmpty()){
                            String descrizione = riga;
                            riga=bf.readLine();
                            String[] splitProd = riga.split(" ");
                            int qVenduta=Integer.parseInt(splitProd[0]);
                            int prezzo=Integer.parseInt(splitProd[1]);
                            listaProdotti.add(new Prodotto(descrizione, qVenduta, prezzo));
                        }
                        listaTransazioni.add(new Privato(tipoTransazione, data, codiceTransazione, listaProdotti, nomeCognome, indirizzo, CF));
                    }
                    case "professionista"->{
                        String tipoTransazione = split[0];
                        int codiceTransazione = Integer.parseInt(split[1]);
                        String data = bf.readLine();
                        String ragioneSociale = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        int pIva=Integer.parseInt(split[0]);
                        int codCliente=Integer.parseInt(split[1]);
                        List<Prodotto> listaProdotti = new ArrayList<>();
                        while((riga=bf.readLine())!=null&&!riga.trim().isEmpty()){
                            String descrizione = riga;
                            riga=bf.readLine();
                            split = riga.split(" ");
                            int qVenduta=Integer.parseInt(split[0]);
                            int prezzo=Integer.parseInt(split[1]);
                            listaProdotti.add(new Prodotto(descrizione, qVenduta, prezzo));
                        }
                        listaTransazioni.add(new Professionista(tipoTransazione, codiceTransazione, data,listaProdotti, ragioneSociale, pIva, codCliente));
                    }
                    default->{
                        System.out.println("Tipo di transazione non trovata");
                    }
                }
                

            }
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("Errore nell'apertura del file");
        }
        System.out.println("------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","ID","Data","Nome","Indirizzo","CodiceFiscale", "RagioneSociale","P.IVA","codCliente");
        for(Transazione t:listaTransazioni){
            int maxLen=20;
            switch (t) {
                case Privato p->{
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                        p.getCodiceTransazione(),
                        troncate(p.getData(), maxLen),
                        troncate(p.getNomeCognome(), maxLen),
                        troncate(p.getIndirizzo(), maxLen),
                        troncate(p.getCF(), maxLen),
                        "-",
                        "-",
                        "-"
                    );
                }
                case Professionista pf->{
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                        pf.getCodiceTransazione(),
                        troncate(pf.getData(), maxLen),
                        "-",
                        "-",
                        "-",
                        troncate(pf.getRagioneSociale(), maxLen),
                        pf.getpIVA(),
                        pf.getCodCliente()
                    );
                }
                default->{/* nessuna azione richiesta */}
            }

        }
        int prezzoTotale=0;
        System.out.println("Lista Transazioni");
        for(Transazione t : listaTransazioni){
            System.out.println("-----------------------------");
            System.out.println("Codice transazione: "+t.getCodiceTransazione());
            int prezzo=0;
            for(Prodotto p: t.getListaProdotti()){
                prezzo+=p.getPrezzo()*p.getQVenduta();
                prezzoTotale+=p.getPrezzo()*p.getQVenduta();
            }
            System.out.println("Totale: "+prezzo+"$");
        }
        System.out.println("-----------------------------");
        System.out.println("Prezzo totale di tutte le transazioni: "+prezzoTotale+"$");
    }
    public static String troncate(String s,int maxLen){
        if(s==null)return "-";
        return (s.length()>maxLen)?s.substring(0,maxLen-3)+"...":s;
    }
}
