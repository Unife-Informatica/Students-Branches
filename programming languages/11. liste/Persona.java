public class Persona {
  private String nome, cognome;
  int eta;

  public Persona(String nome, String cognome, int eta) {
    this.nome = nome;
    this.cognome = cognome;
    this.eta = eta;
  }

  public String toString() {
    return "Nome: " + this.nome + "\ncognome: " + this.cognome + "\neta: " + this.eta;
  }
}
