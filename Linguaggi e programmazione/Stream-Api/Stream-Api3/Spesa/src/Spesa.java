public class Spesa {
    // L'importo in euro
    private double importo;
    // La tipologia di spesa
    private String tipologia;

    public Spesa

    (double importo, String tipologia) {

        this.importo = importo;

        this.tipologia = tipologia;

    }

    public double getImporto() {
        return importo;

    }

    public String getTipologia() {
        return tipologia;

    }
    @Override
    public String toString() {
        return "Spesa [importo=" + importo + ", tipologia=" + tipologia + "]";

    }
}

