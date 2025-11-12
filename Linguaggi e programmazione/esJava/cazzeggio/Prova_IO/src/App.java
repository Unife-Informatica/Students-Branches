
import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        try(BufferedReader bf = new BufferedReader(new FileReader("scontrini.txt"))){
            String riga = bf.readLine();
            while(riga!=null&&!riga.trim().isEmpty()){
                String[] split = riga.split(" ");
                String tipoScontrino = split[0];
                int id = Integer.parseInt(split[1]);
                riga = bf.readLine();
                split = riga.split(" ");
                
            }
        }catch(Exception e){
            System.out.println("File non trovato dio cane!");
        }
    }
}
