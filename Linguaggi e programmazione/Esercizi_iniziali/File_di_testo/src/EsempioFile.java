
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.IIOException;

public class EsempioFile {
    public static void main(String[] args) throws Exception {
        //scrittura su file
        try {
            WriteLines wr = new WriteLines(args[0]);//args[0] nome file di output
        } catch (IIOException ext) {
            System.err.println("Errore di I/O");
            System.exit(1);
        } catch(ArrayIndexOutOfBoundsException ex){

            System.out.println("Errore nel passaggio degli argomenti. Specificare il nome del file");
            System.exit(1);
        }
        //lettura da file
        try {
            ReadFile rf = new ReadFile(args[0]);
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not found.");
            System.exit(1);
        }
        catch (IOException e){
            System.out.println(e);
            System.exit(1);
        }
    }
}
