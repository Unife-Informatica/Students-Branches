public abstract class Iscritto{
    protected String nomeCognome, tipoIscritto, indirizzo;
    protected int codiceIscritto, eta;
    public Iscritto(String nomeCognome, int codiceIscritto, String tipoIscritto, int eta, String indirizzo){
        this.nomeCognome=nomeCognome;
        this.codiceIscritto=codiceIscritto;
        this.tipoIscritto=tipoIscritto;
        this.eta=eta;
        this.indirizzo=indirizzo;
    }
    public String getNomeCognome() {
        return nomeCognome;
    }
    public String getTipoIscritto() {
        return tipoIscritto;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public int getCodiceIscritto() {
        return codiceIscritto;
    }
    public int getEta() {
        return eta;
    }
    

}