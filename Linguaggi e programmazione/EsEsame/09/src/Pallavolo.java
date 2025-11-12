public class Pallavolo extends Squadra {
    int nVinte,nPerse;
    float mSetV;
    public Pallavolo(String nomeSquadra, String tipoSport, int codiceSquadra, int nVinte, int nPerse, float mSetV) {
        super(nomeSquadra, tipoSport, codiceSquadra);
        this.nVinte = nVinte;
        this.nPerse = nPerse;
        this.mSetV = mSetV;
    }
    public int getnVinte() {
        return nVinte;
    }
    public int getnPerse() {
        return nPerse;
    }
    public float getmSetV() {
        return mSetV;
    }
    
}
