public class Basket extends Squadra {
    
    private int nPartiteVinte;
    private int nPartitePerse;
    private float punteggioMedio;
    
    public Basket (String nomeSquadra, int codice, String tipoSport, int nPartiteVinte, int nPartitePerse, float punteggioMedio) {
        super(nomeSquadra, codice, tipoSport);
        this.nPartiteVinte = nPartiteVinte;
        this.nPartitePerse = nPartitePerse;
        this.punteggioMedio = punteggioMedio;
    }

    public int getNPartiteVinte() {
        return nPartiteVinte;
    }

    public int getNPartitePerse() {
        return nPartiteVinte;
    }

    public float getPunteggioMedio() {
        return punteggioMedio;
    }
}
