import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
        List<Iscritto> listaIscritti = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("iscritti.txt"))) {
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String nomeCognome = riga;
                riga=bf.readLine();
                String[] split = riga.split(" ");
                int codiceIscritto = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "docente"->{
                        String tipoIscritto = split[1];
                        int eta = Integer.parseInt(split[2]);
                        String corsoPrincipale = bf.readLine();
                        String indirizzo = bf.readLine();
                        listaIscritti.add(new Docente(nomeCognome, codiceIscritto, tipoIscritto, eta, corsoPrincipale, indirizzo));
                    }
                    case "studente"->{
                        String tipoIscritto = split[1];
                        int eta = Integer.parseInt(split[2]);
                        float votoMedio = Float.parseFloat(bf.readLine());
                        String indirizzo = bf.readLine();
                        listaIscritti.add(new Studente(nomeCognome, codiceIscritto, tipoIscritto, eta, votoMedio, indirizzo));
                    }
                    default->{}
                }
            }
        } catch (Exception e) {
            System.out.println("Errore nella lettura del file iscritti.txt");
        }
        System.out.println("-----------------------------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Tipo","Nome","Codice","Eta'","Corso Principale","Media","Indirizzo");
        int maxLen = 20;
        for(Iscritto i:listaIscritti){
            switch(i){
                case Docente d->{
                    System.out.printf("%-20s %-20s %-20d %-20d %-20s %-20s %-20s%n",
                        truncate(d.getTipoIscritto(), maxLen),
                        truncate(d.getNomeCognome(), maxLen),
                        d.getCodiceIscritto(),
                        d.getEta(),
                        truncate(d.getCorsoPrincipale(), maxLen),
                        "-",
                        truncate(d.getIndirizzo(), maxLen)

                    );
                }
                case Studente s->{
                    System.out.printf("%-20s %-20s %-20d %-20d %-20s %-20s %-20s%n",
                        truncate(s.getTipoIscritto(), maxLen),
                        truncate(s.getNomeCognome(), maxLen),
                        s.getCodiceIscritto(),
                        s.getEta(),
                        "-",
                        s.getVotoMedio(),
                        truncate(s.getIndirizzo(), maxLen)

                    );
                }
                default->{/* Nessuna azione richiesta */}
            } 
        }
        System.out.println("-----------------------------------");
        /* Lettura file contatti */
        List<Contatto> listaContatti = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("contatti.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty())continue;
                String[] split = riga.split(" ");
                int codiceIscritto = Integer.parseInt(split[0]);
                List<Integer> listaCollegati = new ArrayList<>();
                for(int j=1;j<split.length;j++){
                    int codCollegati = Integer.parseInt(split[j]);
                    listaCollegati.add(codCollegati);
                }
                listaContatti.add(new Contatto(codiceIscritto, listaCollegati));
            }
        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file contatti.txt");
        }
        /* Punto 4 */
        System.out.println("Punto 4\n");
        System.out.printf("%-20s %-20s%n","Nome e cognome","Media eta' di iscritti");
        for(Contatto c:listaContatti){
            for(Iscritto i: listaIscritti){
                if(i.getTipoIscritto().equals("docente")&&c.getCodiceIscritto()==i.getCodiceIscritto()){
                    int cont=0;
                    int sommaEta=0;
                    System.out.printf("%-20s %-20d%n",truncate(i.getNomeCognome(), maxLen),i.getCodiceIscritto());
                        for(Integer it:c.getListaCollegati()){
                            for(Iscritto is:listaIscritti){
                                if(it==is.getCodiceIscritto()){
                                    sommaEta+=is.getEta();
                                    cont++;
                                    System.out.printf(" %-20s %-20d%n",
                                        truncate(is.getNomeCognome(), maxLen),
                                        is.getEta()
                                    );
                                }
                            }
                        }
                    System.out.printf("Media delle eta' degli iscritti %-20d%n",
                        sommaEta/cont
                    );
                    System.out.println("");
                    
                }
            }
        }
        System.out.println("-----------------------------------");
        /* Punto 5 */
        System.out.println("Punto 5\n");
        System.out.printf("%-20s %-20s%n","Nome e cognome","Iscritti collegati");
        for(Contatto c:listaContatti){
            for(Iscritto i:listaIscritti){
                if(i.getTipoIscritto().equals("studente")&&c.getCodiceIscritto()==i.getCodiceIscritto()){
                    int contIscritti=0;
                    System.out.printf("%-20s %-20d%n", truncate(i.getNomeCognome(), maxLen),i.getCodiceIscritto());
                    for(Integer it:c.getListaCollegati()){
                        for(Iscritto is:listaIscritti){
                            if(it==is.getCodiceIscritto()){
                                System.out.printf(" %-20s%n",truncate(is.getNomeCognome(), maxLen));
                                contIscritti++;
                            }
                        }
                    }
                    System.out.printf("Il numero di iscritti collegati %-20d%n",contIscritti);
                    System.out.println("");
                }
            }
        }
        

    }
    public static String truncate(String s,int maxLen){
        if(s==null) return "-";
        return (s.length()>maxLen)?s.substring(0,maxLen-3)+"...":s;
    }
}