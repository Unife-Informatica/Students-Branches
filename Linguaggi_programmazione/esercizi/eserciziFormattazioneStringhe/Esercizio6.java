public class Esercizio6 {
  public static void main(String[] args) {
    String nome = "Alice";
    int eta = 25;
    double stipendio = 1234.567;
    String formato = String.format("Nome: %s, Eta: %d, Stipendio: %.2f", nome, eta, stipendio);
    System.out.println(formato);
  }
}
