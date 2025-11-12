public class Pallavolo extends Squadra {
    
    private int nPartiteVinte;
    private int nPartitePerse;
    private float nMedioSetVinti;

    public Pallavolo (String nomeSquadra, int codice, String tipoSport, int nPartiteVinte, int nPartitePerse, float nMedioSetVinti) {
        super(nomeSquadra, codice, tipoSport);
        this.nPartiteVinte = nPartiteVinte;
        this.nPartitePerse = nPartitePerse;
        this.nMedioSetVinti = nMedioSetVinti;
    }

    public int getNPartiteVinte() {
        return nPartiteVinte;
    }

    public int getNPartitePerse() {
        return nPartitePerse;
    }

    public float getNMedioSetVinti() {
        return nMedioSetVinti;
    }

}
