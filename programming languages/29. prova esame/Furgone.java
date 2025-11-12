
public class Furgone {

    private final boolean rimorchio, carico;
    private final int posti;

    public Furgone(boolean rimorchio, boolean carico, int posti) {
        this.rimorchio = rimorchio;
        this.carico = carico;
        this.posti = posti;
    }

    public boolean isRimorchio() {
        return rimorchio;
    }

    public boolean isCarico() {
        return carico;
    }

    public int getPosti() {
        return posti;
    }

}
