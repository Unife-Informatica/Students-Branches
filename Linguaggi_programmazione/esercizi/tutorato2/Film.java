public class Film {
  private String codice;
  private String titolo, genere;

  public Film(String codice, String titolo, String genere){
    this.codice = codice;
    this.titolo = titolo;
    this.genere = genere;
  }

  public String getCodice(){
    return this.codice;
  }

  public String getTitolo(){
    return this.titolo;
  }

  public String getGenere(){
    return this.genere;
  }
}
