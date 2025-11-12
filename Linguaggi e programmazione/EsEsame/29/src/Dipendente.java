public abstract class Dipendente {
    int codDipendente;
    String tipoDipendente,nomeDipendente;
    public Dipendente(int codDipendente, String tipoDipendente, String nomeDipendente) {
        this.codDipendente = codDipendente;
        this.tipoDipendente = tipoDipendente;
        this.nomeDipendente = nomeDipendente;
    }
    public int getCodDipendente() {
        return codDipendente;
    }
    public String getTipoDipendente() {
        return tipoDipendente;
    }
    public String getNomeDipendente() {
        return nomeDipendente;
    }
    public abstract double getCosto();
    

}
