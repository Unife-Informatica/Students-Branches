public class RepertiConsultati {
    private final int codiceArticolo, numeroGiorni;

    public RepertiConsultati(int codiceArticolo, int numeroGiorni) {
        this.codiceArticolo = codiceArticolo;
        this.numeroGiorni = numeroGiorni;
    }

    public int getCodiceArticolo() {
        return codiceArticolo;
    }

    public int getNumeroGiorni() {
        return numeroGiorni;
    }

    @Override
    public String toString() {
        return "(" + getCodiceArticolo() + "," + getNumeroGiorni() + ")";
    }
}
