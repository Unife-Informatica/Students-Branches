public abstract class Dipendente{
    protected int codDipendente;
    protected String tipoDipendente,nomeCognome;
    public Dipendente(int codDipendente, String tipoDipendente, String nomeCognome) {
        this.codDipendente = codDipendente;
        this.tipoDipendente = tipoDipendente;
        this.nomeCognome = nomeCognome;
    }
    public int getCodDipendente() {
        return codDipendente;
    }
    public String getTipoDipendente() {
        return tipoDipendente;
    }
    public String getNomeCognome() {
        return nomeCognome;
    }
    public abstract double getCostoOrario();
}