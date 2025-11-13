public class Prodotto {
  private int codice;
  private String nome;
  private double prezzo;

  public Prodotto(int codice, String nome, double prezzo){
    this.codice = codice;
    this.nome = nome;
    this.prezzo = prezzo;
  }

  public int getCodice(){
    return this.codice;
  }

  public String getNome(){
    return this.nome;
  }

  public double getPrezzo(){
    return this.prezzo;
  }

}
