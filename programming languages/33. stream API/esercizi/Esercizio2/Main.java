import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        // CREAZIONE AUTORI
        Autore king = new Autore("King", "horror");
        Autore kinsella = new Autore("Kinsella", "romantico");
        Autore dicker = new Autore("Dicker", "thriller");

        // CREAZIONE LISTA LIBRI
        List<Libro> libri = new ArrayList<>();
        libri.add(new Libro("It", king, 1986));
        libri.add(new Libro("La scomparsa di Stephanie Mailer", dicker, 2018));
        libri.add(new Libro("Il caso Alaska Sanders", dicker, 2022));
        libri.add(new Libro("Sorprendimi!", kinsella, 2018));
        libri.add(new Libro("L’ultima missione di Gwendy", king, 2022));
        libri.add(new Libro("The Outsider", king, 2018));
        libri.add(new Libro("Holly", king, 2023));

        // =====================================================================
        // 1) TROVARE TUTTI I LIBRI USCITI NEL 2023
        // =====================================================================

        /*
           Stream API:
           - stream(): crea un flusso di elementi
           - filter(): seleziona solo gli oggetti che rispettano una condizione
           - toList(): raccoglie i risultati in una nuova lista
        */
        List<Libro> libri2023 = libri.stream()
                .filter(l -> l.getAnno() == 2023)   // condizione: anno = 2023
                .toList();

        System.out.println("Libri del 2023:");
        libri2023.forEach(System.out::println);

        // =====================================================================
        // 2) TROVARE TUTTI I GENERI PRESENTI (VALORI UNICI)
        // =====================================================================

        /*
           - map(): trasforma ogni libro nel suo genere
           - distinct(): elimina i duplicati
        */
        List<String> generi = libri.stream()
                .map(l -> l.getAutore().getGenere())  // prendo il genere dell'autore
                .distinct()                           // genero una lista senza duplicati
                .toList();

        System.out.println("\nGeneri presenti:");
        generi.forEach(System.out::println);

        // =====================================================================
        // 3) AUTORI UNICI ORDINATI IN ORDINE ALFABETICO
        // =====================================================================

        /*
           - distinct(): serve a evitare duplicati, confrontando tramite equals()
           - sorted(): ordina alfabeticamente comparando il nome dell'autore
        */
        List<Autore> autoriOrdinati = libri.stream()
                .map(Libro::getAutore)                        // estraggo autore
                .distinct()                                   // evito duplicati
                .sorted(Comparator.comparing(Autore::getNome)) // ordino per nome
                .toList();

        System.out.println("\nAutori ordinati alfabeticamente:");
        autoriOrdinati.forEach(System.out::println);

        // =====================================================================
        // 4) VERIFICARE SE LA LISTA CONTIENE L’AUTORE "Volo"
        // =====================================================================

        /*
           - anyMatch(): verifica se almeno un elemento rispetta la condizione
        */
        boolean contieneVolo = libri.stream()
                .anyMatch(l -> l.getAutore().getNome().equals("Volo"));

        System.out.println("\nLa lista contiene l’autore Volo? " + contieneVolo);

        // =====================================================================
        // 5) STAMPARE TUTTI I LIBRI DI GENERE "thriller"
        // =====================================================================

        System.out.println("\nLibri di genere thriller:");

        libri.stream()
                .filter(l -> l.getAutore().getGenere().equals("thriller"))
                .forEach(System.out::println);
    }
}

