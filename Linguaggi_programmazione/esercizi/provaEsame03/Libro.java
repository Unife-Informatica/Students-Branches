public class Libro {
  private String titolo, autore;
  private int prezzo;

  public Libro(String titolo, String autore, int prezzo){
    this.titolo=titolo;
    this.autore=autore;
    this.prezzo=prezzo;
  }

  public String getTitolo(){
    return this.titolo;
  }

  public String getAutore(){
    return this.autore;
  }

  public int getPrezzo(){
    return this.prezzo;
  }
}
