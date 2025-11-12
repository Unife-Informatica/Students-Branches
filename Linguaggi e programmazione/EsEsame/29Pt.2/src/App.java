import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Dipendente> listaDipendenti = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("dipendenti.txt"))){
            String riga;
            while((riga=bf.readLine())!=null){
                if(riga.trim().isEmpty()) continue;
                String[] split = riga.split(" ");
                int codCliente = Integer.parseInt(split[0]);
                switch(split[1]){
                    case "trainer"->{
                        //srgfwgrght
                        String tipoDipendente = split[1];
                        String nomeCognome = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        int oreSettimanali = Integer.parseInt(split[0]);
                        double costoOrario = Double.parseDouble(split[1]);
                        String specialita = bf.readLine();
                        listaDipendenti.add(new Trainer(codCliente, tipoDipendente, nomeCognome, oreSettimanali, costoOrario, specialita));
                    }
                    case "nutrizionista"->{
                        String tipoDipendente = split[1];
                        String nomeCognome = bf.readLine();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        String numTel = split[0];
                        boolean medico = Boolean.parseBoolean(split[1]);
                        int appSettimanali = Integer.parseInt(split[2]);
                        double costoOrario = Integer.parseInt(split[3]);
                        listaDipendenti.add(new Nutrizionista(codCliente, tipoDipendente, nomeCognome, numTel, medico, appSettimanali, costoOrario));
                    }
                    default->{
                        System.out.println("Cazzo non esiste quel dipendente");
                    }
                }
            }
        } catch (Exception e) {
            System.err.print("Errore nella lettura dipendenti.txt");
            e.printStackTrace();
        }
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s%n","Nome","Codice","Tipo","Ore settimanali","Specialita'","Telefono","Medico","App. sett.","Costo Orario");
        for(Dipendente d: listaDipendenti){
            switch(d){
                case Trainer t->{
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                        q
                    );
                }
                case Nutrizionista n->{

                }
                default->{
                    /* Nessuna azione richiesta */
                }
            }
        }
    }
}
