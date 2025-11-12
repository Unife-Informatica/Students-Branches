public class Giocatore {
    String cognome,ruolo;
    int codiceSquadra,eta,numMaglia;
    String titolare;
    public Giocatore(String cognome, String ruolo, int codiceSquadra, int eta, int numMaglia, String titolare) {
        this.cognome = cognome;
        this.ruolo = ruolo;
        this.codiceSquadra = codiceSquadra;
        this.eta = eta;
        this.numMaglia = numMaglia;
        this.titolare = titolare;
    }
    public String getCognome() {
        return cognome;
    }
    public String getRuolo() {
        return ruolo;
    }
    public int getCodiceSquadra() {
        return codiceSquadra;
    }
    public int getEta() {
        return eta;
    }
    public int getNumMaglia() {
        return numMaglia;
    }
    public String isTitolare() {
        return titolare;
    }
    
}
