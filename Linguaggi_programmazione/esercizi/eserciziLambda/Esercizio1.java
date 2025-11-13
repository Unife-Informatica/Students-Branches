public class Esercizio1 {
  public static void main(String[] args) {
    Calcolatore calcolatore = (a,b) -> a + b;

    int ris = calcolatore.calcola(5, 3);

    System.out.println(ris);
  }

  interface Calcolatore{
    int calcola(int a, int b);
  }
}
