public class Esercizio3 {
  public static void main(String[] args) {
    CalcolatoreArea calcolatore = raggio -> Math.PI * raggio * raggio;

    double raggio = 2.5;

    double area = calcolatore.calcola(raggio);

    System.out.println(area);
  }

  interface CalcolatoreArea{
    double calcola(double raggio);
  }
}
