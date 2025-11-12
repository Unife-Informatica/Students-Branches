
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Soci {

    public Soci(String filePath) {
        loadDataFromFile(filePath);
    }

    private void loadDataFromFile(String filePath) {
        try(Scanner sc = new Scanner(new File(filePath))) {
            while(sc.hasNextLine()) {
                int codice = Integer.parseInt(sc.nextLine());

                if(!sc.hasNextLine()) break;
                String nome = sc.nextLine();

                if(!sc.hasNextLine()) break;
                String[] line = sc.nextLine().split(" ");
                int eta = Integer.parseInt(line[0]);
                int categoria = Integer.parseInt(line[1]);

                if(!sc.hasNextLine()) break;
                String prenotazioni = sc.nextLine();

                StringTokenizer st = new StringTokenizer(prenotazioni);
                while(st.hasMoreTokens()) {
                    int ora = Integer.parseInt(st.nextToken());
                    int campo = Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException e) {

        }
    }
}
