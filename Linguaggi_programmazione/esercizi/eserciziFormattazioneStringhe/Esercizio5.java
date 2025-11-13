public class Esercizio5 {
  public static void main(String[] args) {
    int numero = 12345678;
    String formato = String.format("%,d", numero);
    System.out.println(formato);
  }
}
