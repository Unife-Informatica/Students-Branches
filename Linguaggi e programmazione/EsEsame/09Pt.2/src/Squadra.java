public abstract class Squadra {
    
    protected String nomeSquadra;
    protected int codice;
    protected String tipoSport;

    public Squadra(String nomeSquadra, int codice, String tipoSport) {
        this.nomeSquadra = nomeSquadra;
        this.codice = codice;
        this.tipoSport = tipoSport;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public int getCodice() {
        return codice;
    }

    public String getTipoSport() {
        return tipoSport;
    }
}
