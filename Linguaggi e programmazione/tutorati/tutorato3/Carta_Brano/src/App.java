import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        CartaBrano[] carte = new CartaBrano[5];
        Path fileCarte=Path.of("carte.txt");

        try(BufferedReader bf = new BufferedReader(new FileReader(fileCarte.toFile()))){
            int i=0;
            String riga = bf.readLine();
            while(riga!=null && !riga.trim().isEmpty()){
                String [] split = riga.split(",");
                String codice = split[0].trim();
                int brani = Integer.parseInt(split[1].trim());
                boolean attiva = Boolean.parseBoolean(split[2].trim());
                carte[i]= new CartaBrano(codice, brani, attiva);
                i++;
                riga = bf.readLine();
            }
        }catch(IOException ioe){
            throw new RuntimeException("Errore durante la lettura del file carte.txt");
        }
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            System.out.println("Carte disponibili: ");
            for (int i = 0; i < carte.length; i++) {
                CartaBrano carta = carte[i];
                System.out.println("Codice: "+carta.getCodice());
            }
            
        }
        
        
    }
}
