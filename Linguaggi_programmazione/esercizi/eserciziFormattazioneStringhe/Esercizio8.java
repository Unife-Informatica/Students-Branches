public class Esercizio8 {
  public static void main(String[] args) {
    int positivo = 123;
    int negativo = -123;
    String formatoPositivo = String.format("%+d", positivo);
    String formatoNegativo = String.format("%+d", negativo);
    System.out.println(formatoPositivo);
    System.out.println(formatoNegativo);
  }
}
