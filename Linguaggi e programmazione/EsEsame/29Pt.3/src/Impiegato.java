public abstract class Impiegato{
    protected int codImpiegato;
    protected String tipoImpiegato,nomeCognome;
    public Impiegato(int codImpiegato, String tipoImpiegato, String nomeCognome) {
        this.codImpiegato = codImpiegato;
        this.tipoImpiegato = tipoImpiegato;
        this.nomeCognome = nomeCognome;
    }
    public int getCodImpiegato() {
        return codImpiegato;
    }
    public String getTipoImpiegato() {
        return tipoImpiegato;
    }
    public String getNomeCognome() {
        return nomeCognome;
    }
    public abstract double getCostOrario();
    
}