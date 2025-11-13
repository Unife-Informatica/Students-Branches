public class Prenotazione {
  private int codiceEventoPren, postoAss;
  private String nome, cognome, accompagnatore;
  
  public Prenotazione(int codiceEventoPren, int postoAss, String nome, String cognome, String accompagnatore) {
    this.codiceEventoPren = codiceEventoPren;
    this.postoAss = postoAss;
    this.nome = nome;
    this.cognome = cognome;
    this.accompagnatore = accompagnatore;
  }

  public int getCodiceEventoPren() {
    return codiceEventoPren;
  }

  public int getPostoAss() {
    return postoAss;
  }

  public String getNome() {
    return nome;
  }

  public String getCognome() {
    return cognome;
  }

  public String getAccompagnatore() {
    return accompagnatore;
  }
}
