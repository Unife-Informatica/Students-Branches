
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
        List<Filiale> listaFiliali = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("filiali.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                String nome = riga;
                int codice = Integer.parseInt(bf.readLine());
                String indirizzo = bf.readLine();
                List<Cliente> listaClienti = new ArrayList<>();
                try(BufferedReader bfc = new BufferedReader(new FileReader("clienti.txt"))) {
                    String rigac;
                    while((rigac=bfc.readLine())!=null){
                        if(rigac.trim().isEmpty())continue;
                        String[] split = rigac.split(" ");
                        switch(split[0]){
                            case "privato"->{
                                String tipoCliente = split[0];
                                int codCliente = Integer.parseInt(split[1]);
                                String nomeCognome = bfc.readLine();
                                int codFiliale = Integer.parseInt(bfc.readLine());
                                rigac=bfc.readLine();
                                split = rigac.split(" ");
                                List<Integer> listaExFiliali = new ArrayList<>();
                                for(int i=0;i<split.length;i++){
                                    int num = Integer.parseInt(split[i]);
                                    listaExFiliali.add(num);
                                }
                                float premioCorrente = Float.parseFloat(bfc.readLine());
                                if(codice==codFiliale){
                                    listaClienti.add(new Privato(tipoCliente, codCliente, codFiliale, listaExFiliali, premioCorrente, nomeCognome));
                                }
                            }
                            case "azienda"->{
                                String tipoCliente = split[0];
                                int codCliente = Integer.parseInt(split[1]);
                                String ragSociale = bfc.readLine();
                                int codFiliale = Integer.parseInt(bfc.readLine());
                                rigac=bfc.readLine();
                                split = rigac.split(" ");
                                List<Integer> listaExFiliali = new ArrayList<>();
                                for(int i=0;i<split.length;i++){
                                    int num = Integer.parseInt(split[i]);
                                    listaExFiliali.add(num);
                                }
                                float premioCorrente = Float.parseFloat(bfc.readLine());
                                float premioCorrenteTax = Float.parseFloat(bfc.readLine()); 
                                
                                if(codice==codFiliale){
                                    listaClienti.add(new Azienda(tipoCliente, codCliente, codFiliale, listaExFiliali, premioCorrente, ragSociale, premioCorrenteTax));

                                }
                            }
                            default->{
                                System.out.println("tipo di cliente non trovato");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Errore nell'apertura del file clienti.txt");
                }
                listaFiliali.add(new Filiale(nome, indirizzo, codice, listaClienti));
            }
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file filiali.txt");
        }
        System.out.println("----------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Tipo","Nome e Cognome","Ragione Sociale","Codice","Nome Filiale","Premio corrente","Premio corrente tassato");
        for(Filiale f:listaFiliali){
            for(Cliente c:f.getListaClienti()){
                switch(c){
                    case Privato p->{
                        System.out.printf("%-20s %-20s %-20s %-20d %-20s %-20.2f %-20s%n",
                            p.getTipoCliente(),
                            p.getNomeCognome(),
                            "-",
                            p.getCodCliente(),
                            f.getNome(),
                            p.getPremioCorrente(),
                            "-"
                        );
                    }
                    case Azienda a->{
                        System.out.printf("%-20s %-20s %-20s %-20d %-20s %-20.2f %-20.2f%n",
                            a.getTipoCliente(),
                            "-",
                            a.getRagSociale(),
                            a.getCodCliente(),
                            f.getNome(),
                            a.getPremioCorrente(),
                            a.getPremioCorrenteTax()
                        );
                    }
                    default->{}
                }
            }
        }
    }

}