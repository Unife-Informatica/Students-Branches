public abstract class Partita {
  protected String tipoPartita, data, ora, risultato;
  protected int vittoria;

  public Partita(String tipoPartita, String data, String ora, String risultato, int vittoria){
    this.tipoPartita=tipoPartita;
    this.data=data;
    this.ora=ora;
    this.risultato=risultato;
    this.vittoria=vittoria;
  }

  public String getTipoPartita(){
    return this.tipoPartita;
  }

  public String getData(){
    return this.data;
  }
  
  public String getOra(){
    return this.ora;
  }

  public String getRisultato(){
    return this.risultato;
  }

  public int getVittoria(){
    return this.vittoria;
  }

  public abstract String getDettaglio();
}
