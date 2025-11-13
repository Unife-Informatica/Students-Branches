public abstract class Automobile {
  protected String tipo, modello, produttore;
  protected int peso, codice;

  public Automobile(String tipo, String modello, String produttore, int peso, int codice){
    this.tipo=tipo;
    this.modello=modello;
    this.produttore=produttore;
    this.peso=peso;
    this.codice=codice;
  }

  public String getTipo(){
    return this.tipo;
  }

  public String getModello(){
    return this.modello;
  }

  public String getProduttore(){
    return this.produttore;
  }

  public int getPeso(){
    return this.peso;
  }

  public int getCodice(){
    return this.codice;
  }

  public abstract String getDatoExtra();
}
