public class Socio {
    int codice, eta, categoria;
    String nome;

    public Socio(int codice, int eta, int categoria, String nome) {
        this.codice = codice;
        this.eta = eta;
        this.categoria = categoria;
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public int getEta() {
        return eta;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }
}
