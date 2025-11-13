public class Esercizio4 {
  public static void main(String[] args) {
    String testo = "Java";
    String formattoSinistra = String.format("%-10s", testo);
    String formattoDestra = String.format("%10s", testo);
    System.out.println(formattoSinistra);
    System.out.println(formattoDestra);
  }
}
