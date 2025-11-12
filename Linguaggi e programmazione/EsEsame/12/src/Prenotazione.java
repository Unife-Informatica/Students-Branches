public class Prenotazione{
    private int codEvento,postoAssegnato;
    private String nome,cognome;
    private boolean dipendente;
    
    public Prenotazione(int codEvento, int postoAssegnato, String nome, String cognome, boolean dipendente) {
        this.codEvento = codEvento;
        this.postoAssegnato = postoAssegnato;
        this.nome = nome;
        this.cognome = cognome;
        this.dipendente = dipendente;
    }
    public int getCodEvento() {
        return codEvento;
    }
    public int getPostoAssegnato() {
        return postoAssegnato;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public boolean isDipendente() {
        return dipendente;
    }
    
}