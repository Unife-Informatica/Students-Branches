import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        if(args.length != 1 || args[0].isEmpty() || args[0] == null) {
          throw new IllegalArgumentException();
        }
        String path = args[0];
        String line;

        clearFile(path);

        do {
            line = console.nextLine();
            if (!line.equals("")) {
                writeInFile(path, line + "\n");
            }
        } while (!line.equals(""));

        printFile(path);
    }

    private static void clearFile(String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInFile(String path, String content) {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(String path) {
        try {
            FileReader reader = new FileReader(path);
            int data = reader.read();

            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Il file " + path + " non esiste.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la lettura del file " + path);
        }
    }
}

