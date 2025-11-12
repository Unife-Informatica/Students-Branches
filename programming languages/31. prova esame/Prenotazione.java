class Prenotazione {
    private final int codiceCampo;
    private final int oraInizio;

    public Prenotazione(int codiceCampo, int oraInizio) {
        this.codiceCampo = codiceCampo;
        this.oraInizio = oraInizio;
    }

    public int getCodice() {
        return codiceCampo;
    }

    @Override
    public String toString() {
        return "(" + codiceCampo + ", " + oraInizio + ")";
    }
}

