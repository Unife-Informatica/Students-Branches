
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public ReadFile(String filename)throws IOException{
        //Stream di input
        //FileReader e' uno stream di dati che permette di collegarsi ad un file di testo in scrittura
        //BufferedReader e' uno stream di manipolazione a caratteri che consente di leggere stringhe 
        FileReader fr = new FileReader(filename);
        BufferedReader inFile = new BufferedReader(fr);
        System.out.println("Il testo salvato e':");
        String line = inFile.readLine();
        //readLine() returns null if the end of the stream has been reached
        while(line!=null){
            System.out.println(line);
            line = inFile.readLine();
        }
        inFile.close();
    }
}
