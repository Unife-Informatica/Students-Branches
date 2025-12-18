import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String DB_FILE = "libri.json";
    private static final ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT); // output leggibile

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<Libro> libri = caricaLibri();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Mostra tutti i libri");
            System.out.println("2) Cerca libro per titolo");
            System.out.println("3) Aggiungi libro");
            System.out.println("4) Salva e esci");
            System.out.print("Scelta: ");
            int scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {

                case 1:
                    mostraLibri(libri);
                    break;

                case 2:
                    System.out.print("Inserisci il titolo da cercare: ");
                    String titolo = input.nextLine();
                    cercaLibro(libri, titolo);
                    break;

                case 3:
                    aggiungiLibro(libri, input);
                    break;

                case 4:
                    salvaLibri(libri);
                    System.out.println("Salvataggio completato. Uscita...");
                    return;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    // ===========================================================
    //      CARICAMENTO E SALVATAGGIO JSON (JACKSON)
    // ===========================================================

    private static List<Libro> caricaLibri() {
        try {
            File file = new File(DB_FILE);

            if (!file.exists()) {
                System.out.println("File libri.json non trovato, creato nuovo database.");
                return new ArrayList<>();
            }

            return mapper.readValue(file, new TypeReference<List<Libro>>() {});
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void salvaLibri(List<Libro> libri) {
        try {
            mapper.writeValue(new File(DB_FILE), libri);
        }
        catch (IOException e) {
            System.out.println("Errore durante il salvataggio!");
            e.printStackTrace();
        }
    }

    // ===========================================================
    //      FUNZIONI OPERATIVE
    // ===========================================================

    private static void mostraLibri(List<Libro> libri) {
        if (libri.isEmpty()) {
            System.out.println("Nessun libro presente.");
            return;
        }

        System.out.println("\n--- LISTA LIBRI ---");
        for (Libro l : libri) {
            System.out.println(
                    l.getTitolo() + " - " + l.getAutore() +
                            " (" + l.getAnno() + ") [ISBN: " + l.getISBN() + "]"
            );
        }
    }

    private static void cercaLibro(List<Libro> libri, String titolo) {
        for (Libro l : libri) {
            if (l.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("\n--- LIBRO TROVATO ---");
                System.out.println("Titolo: " + l.getTitolo());
                System.out.println("Autore: " + l.getAutore());
                System.out.println("Genere: " + l.getGenere());
                System.out.println("Anno: " + l.getAnno());
                System.out.println("ISBN: " + l.getISBN());
                return;
            }
        }

        System.out.println("Libro non trovato.");
    }

    private static void aggiungiLibro(List<Libro> libri, Scanner input) {
        System.out.print("ISBN: ");
        String isbn = input.nextLine();

        System.out.print("Titolo: ");
        String titolo = input.nextLine();

        System.out.print("Autore: ");
        String autore = input.nextLine();

        System.out.print("Genere: ");
        String genere = input.nextLine();

        System.out.print("Anno: ");
        int anno = input.nextInt();
        input.nextLine();

        libri.add(new Libro(isbn, titolo, autore, genere, anno));

        System.out.println("Libro aggiunto con successo!");
    }
}
