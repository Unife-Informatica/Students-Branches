import java.util.Objects;

public class Autore {
    private String nome;
    private String genere;

    // Costruttore
    public Autore(String nome, String genere) {
        this.nome = nome;
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genere);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Autore other = (Autore) obj;
        return Objects.equals(nome, other.nome) &&
               Objects.equals(genere, other.genere);
    }

    @Override
    public String toString() {
        return nome + " (" + genere + ")";
    }
}

