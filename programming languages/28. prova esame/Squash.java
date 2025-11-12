
public class Squash extends Campo {

    float larghezza, lunghezza, altezza, costo;
    int piano;

    public Squash(int codice, String nome, float larghezza, float lunghezza, float altezza, float costo, int piano) {
        super(codice, nome);
        this.larghezza = larghezza;
        this.lunghezza = lunghezza;
        this.altezza = altezza;
        this.costo = costo;
        this.piano = piano;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public float getLunghezza() {
        return lunghezza;
    }

    public float getAltezza() {
        return altezza;
    }

    public float getCosto() {
        return costo;
    }

    public int getPiano() {
        return piano;
    }

    @Override
    public String toString() {
        return "Squash" + "\t" + getNome() + "\t" + getCodice() + "\t" + getLarghezza() + "\t-\t-\t" + getAltezza() + "\t" + getPiano() + "\t" + getCosto();
    }
}
