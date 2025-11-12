
public class Tennis extends Campo {

    private final float tempMedia;
    private final String terreno;

    public Tennis(int codice, float costo, float larghezza, float lunghezza, String nome, float tempMedia,
            String terreno) {
        super(codice, costo, larghezza, lunghezza, nome);
        this.tempMedia = tempMedia;
        this.terreno = terreno;
    }

    public float getTempMedia() {
        return tempMedia;
    }

    public String getTerreno() {
        return terreno;
    }

    @Override
    public String toString() {
        return "tennis\t" + super.toString() + getTempMedia() + "\t" + getTerreno() + "\t-\t-\t" + getCosto();
    }
}
