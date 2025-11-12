import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Scontrino> listaSc = new ArrayList<>();
        try(BufferedReader bf= new BufferedReader(new FileReader("scontrino.txt"))){
            String riga;
            while ((riga = bf.readLine()) != null){ 
                String[] split = riga.split(" ");
                switch(split[0]){
                    case "privato" -> {
                        String tipoCliente = split[0];
                        int id = Integer.parseInt(split[1].trim());
                        String data = bf.readLine().trim();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        String nome = split[0];
                        String cognome = split[1];
                        String indirizzo = bf.readLine().trim();
                        riga = bf.readLine();
                        split = riga.split(" ");
                        String CF = split[0];
                        int codCliente = Integer.parseInt(split[1].trim());
                        listaSc.add(new Privato(tipoCliente,data,id,nome,cognome,indirizzo,CF,codCliente));
                    }
                    case "aziendale"-> {

                    }
                    default->{
                        System.out.println("Tipo di cliente non riconosciuto");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Errore nella lettura del file");
        }
    
        System.out.print(listaSc.get(0).toString());
    }
}
