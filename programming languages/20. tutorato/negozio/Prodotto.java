public class Prodotto {
  int id;
  String nome;
  double prezzo;

  public Prodotto() {}

  public Prodotto(int id, String nome, double prezzo) {
    this.id = id;
    this.nome = nome;
    this.prezzo = prezzo;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPrezzo(double prezzo) {
    this.prezzo = prezzo;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public double getPrezzo() {
    return prezzo;
  }
}