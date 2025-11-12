
public class Squash extends Campo {

    private final int piano;
    private final float altezza;

    public Squash(int codice, float costo, float larghezza, float lunghezza, String nome, float altezza, int piano) {
        super(codice, costo, larghezza, lunghezza, nome);
        this.altezza = altezza;
        this.piano = piano;
    }

    public float getAltezza() {
        return altezza;
    }

    public int getPiano() {
        return piano;
    }

    @Override
    public String toString() {
        return "squash\t" + super.toString() + "\t-\t-\t" + getAltezza() + "\t" + getPiano() + getCosto();
    }
}
