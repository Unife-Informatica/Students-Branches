import java.util.*;

class Individuo {

    private String nome, cognome, residenza;
    private int eta;

    public Individuo(String nome, String cognome, int eta, String residenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.residenza = residenza;
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

    public String getResidenza() {
        return residenza;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " " + eta + " " + residenza;
    }
}

class Anagrafica {

    List<Individuo> listaIndividui = new ArrayList<>();

    public Anagrafica() {}

    public Anagrafica(List<Individuo> listaIndividui) {
        this.listaIndividui = listaIndividui;
    }

    public double calcolaMediaEta(String residenza) {
        return listaIndividui
            .stream()
            .filter(i -> i.getResidenza().equalsIgnoreCase(residenza))
            .mapToInt(Individuo::getEta)
            .average()
            .orElse(0.0);
    }

    public List<Individuo> getIndividuiResidenti(String residenza) {
        return listaIndividui
            .stream()
            .filter(i -> i.getResidenza().equalsIgnoreCase(residenza))
            .toList();
    }
}

public class Esercizio1 {

    public static void main() {
        Anagrafica anagrafica = new Anagrafica(
            Arrays.asList(new Individuo("Mario", "Rossi", 21, "Via"))
        );

        System.out.println(anagrafica.calcolaMediaEta("Via"));

        List<Individuo> listaFiltrata = anagrafica.getIndividuiResidenti("Via");
        for (Individuo i : listaFiltrata) {
            System.out.println(i);
        }
    }
}
