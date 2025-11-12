public class Geologico extends Reperto {
    private final float eta;

    public Geologico(int codice, int anno, String collocazione, int peso, String tipo, String descrizione,
            String ritrovamento, float eta) {
        super(codice, anno, collocazione, peso, tipo, descrizione, ritrovamento);
        this.eta = eta;
    }

    public float getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return super.toString() + getEta() + "\t-\t-";
    }
}
