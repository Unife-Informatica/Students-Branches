public class Prodotto {
  private String nome;
  private double prezzo;

  public Prodotto(String nome, double prezzo){
    this.nome = nome;
    this.prezzo = prezzo;
  }

  public String getNome(){
    return this.nome;
  }

  public double getPrezzo(){
    return this.prezzo;
  }
}
