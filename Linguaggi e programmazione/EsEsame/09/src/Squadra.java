public abstract class Squadra{
    String nomeSquadra,tipoSport;
    int codiceSquadra;
    public Squadra(String nomeSquadra, String tipoSport, int codiceSquadra) {
        this.nomeSquadra = nomeSquadra;
        this.tipoSport = tipoSport;
        this.codiceSquadra = codiceSquadra;
    }
    public String getNomeSquadra() {
        return nomeSquadra;
    }
    public String getTipoSport() {
        return tipoSport;
    }
    public int getCodiceSquadra() {
        return codiceSquadra;
    }
    
}