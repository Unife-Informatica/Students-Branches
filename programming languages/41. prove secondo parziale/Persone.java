import java.util.*;
import java.util.stream.*;

class Persona {

    private String nome, cognome;
    private int eta;
    private List<String> passioni;

    public Persona(
        String nome,
        String cognome,
        int eta,
        List<String> passioni
    ) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.passioni = passioni;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public List<String> getPassioni() {
        return passioni;
    }

    public String toString() {
        return nome + " " + cognome;
    }
}

public class Persone {

    public static void main() {
        List<Persona> listaPersone = Arrays.asList(
            new Persona(
                "Marco",
                "Rossi",
                16,
                Arrays.asList("Calcio", "Musica", "Film")
            ),
            new Persona(
                "Giulia",
                "Bianchi",
                30,
                Arrays.asList("Lettura", "Viaggi")
            ),
            new Persona(
                "Luca",
                "Verdi",
                22,
                Arrays.asList("Palestra", "Cucina", "Tecnologia", "Musica")
            )
        );

        // Persone maggiorenni
        System.out.println(
            "----------------------\nPersone maggiorenni\n----------------------"
        );
        listaPersone
            .stream()
            .filter(p -> p.getEta() >= 18)
            .toList()
            .forEach(e -> System.out.println(e));

        // Ordinamento per eta
        System.out.println(
            "----------------------\nOrdinamento per eta\n----------------------"
        );
        listaPersone
            .stream()
            .sorted(Comparator.comparing(Persona::getEta))
            .forEach(e -> System.out.println(e));

        // Persone con la stessa passione
        System.out.println(
            "----------------------\nPersone con la stessa passione\n----------------------"
        );
        listaPersone
            .stream()
            .flatMap(p ->
                p
                    .getPassioni() // per ogni persona vengono prese tutte le passioni
                    .stream()
                    .map(
                        passione -> new AbstractMap.SimpleEntry<>(passione, p) // per ogni passione si crea una coppia (passione, persona)
                    )
            )
            .collect(
                Collectors.groupingBy(
                    Map.Entry::getKey, // usa la passione come chiave
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList()) // per ogni chiave raccoglie le persone
                )
            )
            .entrySet()
            .stream()
            .forEach(e ->
                System.out.println(
                    e.getKey() +
                        "[" +
                        e.getValue().size() +
                        "]" +
                        " -> " +
                        e.getValue()
                )
            );
    }
}
