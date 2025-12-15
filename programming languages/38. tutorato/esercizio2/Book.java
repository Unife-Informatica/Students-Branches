public class Book {
  private int pubblicazione;
  private double prezzo;
  private String autore, titolo;
  private String[] tags;

  public Book(String titolo, String autore, double prezzo, int pubblicazione, List<String> tags) {
    this.titolo = titolo;
    this.autore = autore;
    this.prezzo = prezzo;
    this.pubblicazione = pubblicazione;
    this.tags = tags;
  }

  public String getTitolo() {
    return titolo;
  }

  public String getAutore() {
    return autore;
  }

  public double getPrezzo() {
    return prezzo;
  }

  public int getPubblicazione() {
    return pubblicazione;
  }

  public List<String> getTags() {
    return tags;
  }
}
