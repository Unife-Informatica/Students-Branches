public class Basket extends Squadra {
    int nVinte,nPerse;
    float pMedio;
    public Basket(String nomeSquadra, String tipoSport, int codiceSquadra, int nVinte, int nPerse, float pMedio) {
        super(nomeSquadra, tipoSport, codiceSquadra);
        this.nVinte = nVinte;
        this.nPerse = nPerse;
        this.pMedio = pMedio;
    }
    public int getnVinte() {
        return nVinte;
    }
    public int getnPerse() {
        return nPerse;
    }
    public float getpMedio() {
        return pMedio;
    }
    
}
