public class CartaPrepagata {
  private String codice;
  private int nBraniDisp;
  private boolean stato;

  public CartaPrepagata(String codice, int nBraniDisp, boolean stato){
    this.codice=codice;
    this.nBraniDisp=nBraniDisp;
    this.stato=stato;
  }

  public String getCodice(){
    return this.codice;
  }

  public void setNBraniDisp(){
    this.nBraniDisp++;
  }

  public int getNBraniDisp(){
    return this.nBraniDisp;
  }

  public void setStato(boolean s){
    this.stato = s;
  }

  public boolean getStato(){
    return this.stato;
  }

  public void acquistaBrano(){
    this.nBraniDisp--;
  }
}
