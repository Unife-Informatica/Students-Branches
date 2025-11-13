public class Persona {
  private String nome;
  private int eta;

  public Persona(String nome, int eta){
    this.nome = nome;
    this.eta = eta;
  }

  public String getNome(){
    return nome;
  }

  public int getEta(){
    return eta;
  }
}
