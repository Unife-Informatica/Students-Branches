enum Genere{
    MASCHIO,
    FEMMINA
  }

public class Persona {
  private String nome, citta;
  private int eta;
  private Genere genere;
  
  public Persona(String nome, String citta, int eta, Genere genere) {
    this.nome = nome;
    this.citta = citta;
    this.eta = eta;
    this.genere = genere;
  }

  public String getNome() {
    return nome;
  }

  public String getCitta() {
    return citta;
  }

  public int getEta() {
    return eta;
  }

  public Genere getGenere() {
    return genere;
  }
  
  public String toString(){
    return nome + " " + eta + " " + genere + " " + citta;
  }
}
