import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception{
        Autore king = new Autore("King", "horror");
        Autore kinsella = new Autore("Kinsella", "romantico");
        Autore dicker = new Autore("Dicker", "thriller");

        List<Libro> libri = new ArrayList<>();
        libri.add(new Libro("It", king, 1986));
        libri.add(new Libro("La scomparsa di Stephanie Mailer", dicker, 2018));
        libri.add(new Libro("Il caso Alaska Sanders", dicker, 2022));
        libri.add(new Libro("Sorprendimi!", kinsella, 2018));
        libri.add(new Libro("L'ultima missione di Gwendy", king, 2022));
        libri.add(new Libro("The Outsider", king, 2018));
        libri.add(new Libro("Holly", king, 2023));
        /*
         * 1. trovare ed inserire in una lista tutti i libri usciti nell’anno 2023
         * presenti nella lista libri;
         */
        List<Libro> uno = libri.stream()
                .filter(l -> l.getAnno() == 2022)
                .collect(Collectors.toList());
        System.out.println(uno + "\n");
        /*
         * 2. trovare ed inserire in una lista tutti i generi presenti nella lista libri
         * (i valori unici);
         */
        List<String> due = libri.stream()
                .map(l -> l.getAutore().getGenere())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(due + "\n");
        /*
         * 3. trovare ed inserire in ordine alfabetico in una lista gli autori presenti
         * nella lista libri (valori unici);
         */
        List<String> tre = libri.stream()
                .map(l -> l.getAutore().getNome())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(tre + "\n");
        /* 4. verificare se la lista libri contiene l’autore Volo */
        boolean containVolo = libri.stream()
                .anyMatch(l -> l.getAutore().getNome().equals("Volo"));
        System.out.println(containVolo + "\n");
        /* 5. trovare e stampare a video tutti i libri di genere thriller presenti nella lista libri.*/
        libri.stream()
            .filter(l->l.getAutore().getGenere().equals("thriller"))
            .map(l->l.getTitolo())
            .sorted()
            .forEach(g->System.out.println("Thriller: "+g));

    }
}
