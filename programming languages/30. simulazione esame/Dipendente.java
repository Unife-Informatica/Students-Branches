
public class Dipendente {

    int codice;
    String nome;
    double costo;

    public Dipendente(int codice, String nome, double costo) {
        this.codice = codice;
        this.nome = nome;
        this.costo = costo;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return getNome() + "\t" + getCodice() + "\t";
    }
}
