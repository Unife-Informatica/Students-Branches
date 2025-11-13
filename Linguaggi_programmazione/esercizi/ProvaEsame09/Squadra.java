import java.util.List;

public abstract class Squadra {
  protected String nomeSquadra, sport;
  protected int codice;
  protected List<Giocatore> listaGiocatori;

  public Squadra(String nomeSqudra, int codice, String sport, List<Giocatore> listaGiocatori){
    this.nomeSquadra=nomeSqudra;
    this.codice=codice;
    this.sport=sport;
    this.listaGiocatori=listaGiocatori;
  }

  public String getNomeSquadra(){
    return this.nomeSquadra;
  }

  public int getCodice(){
    return this.codice;
  }

  public String getSport(){
    return this.sport;
  }

  public List<Giocatore> getListaGiocatori(){
    return this.listaGiocatori;
  }

  public abstract int getDettaglio1();

  public abstract int getDettaglio2();

  public abstract float getDettaglio3();
}
