import java.util.List;

public class Basket extends Squadra{
  private int nPartiteVinte, nPartitePerse;
  private float punteggioMedio;

  public Basket(String nomeSqudra, int codice, String sport, int nPartiteVinte, int nPartitePerse, float punteggioMedio, List<Giocatore> listaGiocatori){
    super(nomeSqudra, codice, sport, listaGiocatori);
    this.nPartiteVinte=nPartiteVinte;
    this.nPartitePerse=nPartitePerse;
    this.punteggioMedio=punteggioMedio;
  }

  public int getDettaglio1(){
    return this.nPartiteVinte;
  }

  public int getDettaglio2(){
    return this.nPartitePerse;
  }

  public float getDettaglio3(){
    return this.punteggioMedio;
  }
}
