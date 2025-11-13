public class Esercizio4 {
  public static final double PI = 3.14;

  public static double calcolaArea(double raggio){
    return PI * raggio * raggio;
  }

  public static void main(String[] args) {
    double raggio = 5.0;
    System.out.println("Area del cerchio: " + calcolaArea(raggio));
  }
}
