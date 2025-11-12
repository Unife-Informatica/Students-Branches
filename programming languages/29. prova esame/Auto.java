public class Auto extends Veicolo {
    private final double capienza;
    private final int cilindrata;
    private final String categoria;

    public Auto(int codice, String targa, String modello, String marca, double costo, double capienza, int cilindrata, String categoria) {
        super(cilindrata, categoria, categoria, categoria, capienza);
        this.capienza = capienza;
        this.cilindrata = cilindrata;
        this.categoria = categoria;
    }

    public double getCapienza() {
        return capienza;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getCategoria() {
        return categoria;
    }
}
