
public class Campo {

    private final int codice;
    private final String nome;
    private final float larghezza, lunghezza, costo;

    public Campo(int codice, float costo, float larghezza, float lunghezza, String nome) {
        this.codice = codice;
        this.costo = costo;
        this.larghezza = larghezza;
        this.lunghezza = lunghezza;
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public float getLunghezza() {
        return lunghezza;
    }

    public float getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return getNome() + "\t" + getCodice() + "\t" + getLarghezza() + "\t" + getLunghezza() + "\t";
    }
}
