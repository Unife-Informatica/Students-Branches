public class Veicolo {
    private final int codice;
    private final String targa, modello, marca;
    private final double costo;

    public Veicolo(int codice, String targa, String modello, String marca, double costo) {
        this.codice = codice;
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.costo = costo;
    }

    public int getCodice() {
        return codice;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public String getMarca() {
        return marca;
    }

    public double getCosto() {
        return costo;
    }
}
