import java.util.List;

public class Pallavolo extends Squadra{
  private int nPartiteVinte, nPartitePerse;
  private float nMedioSetVinti;

  public Pallavolo(String nomeSqudra, int codice, String sport, int nPartiteVinte, int nPartitePerse, float nMedioSetVinti, List<Giocatore> listaGiocatori){
    super(nomeSqudra, codice, sport, listaGiocatori);
    this.nPartiteVinte=nPartiteVinte;
    this.nPartitePerse=nPartitePerse;
    this.nMedioSetVinti=nMedioSetVinti;
  }
  
  public int getDettaglio1(){
    return this.nPartiteVinte;
  }

  public int getDettaglio2(){
    return this.nPartitePerse;
  }

  public float getDettaglio3(){
    return this.nMedioSetVinti;
  }
}
