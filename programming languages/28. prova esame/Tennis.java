public class Tennis extends Campo {
    float larghezza, lunghezza, tempMedia, costo;
    String terreno;

    public Tennis(int codice, String nome, float larghezza, float lunghezza, float tempMedia, float costo, String terreno) {
        super(codice, nome);
        this.larghezza = larghezza;
        this.lunghezza = lunghezza;
        this.tempMedia = tempMedia;
        this.costo = costo;
        this.terreno = terreno;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public float getLunghezza() {
        return lunghezza;
    }

    public float getTempMedia() {
        return tempMedia;
    }

    public float getCosto() {
        return costo;
    }

    public String getTerreno() {
        return terreno;
    }

    @Override
    public String toString() {
        return "Tennis" + "\t" + getNome() + "\t" + getCodice() + "\t" + getLarghezza() + "\t" + getTempMedia() + "\t" + getTerreno() + "\t-\t-\t" + getCosto();
    }
}
