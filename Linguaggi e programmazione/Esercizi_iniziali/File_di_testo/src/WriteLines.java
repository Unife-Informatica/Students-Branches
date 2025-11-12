
import java.io.*;

public class WriteLines{
    public WriteLines(String filename)throws IOException{
        //Stream di output
        //FileWriter e' uno stream di dati che permette di "collegarsi" ad un file di testo in scrittura
        //PrintWriter e' uno stream di manipolazione per scrivere righe di testo
        PrintWriter output = new PrintWriter(new FileWriter(filename));
        //stream di input
        //InputStreamReader converte uno stream di byte in uno stream di caratteri
        //BufferedReader e' uno stream di manipolazione a caratteri che consente di leggere stringhe
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il testo da salvere: ");
        String line = input.readLine();
        while(!line.equals("")){
            output.println(line);
            line=input.readLine();
        }
        input.close();
        output.close();
    }
}