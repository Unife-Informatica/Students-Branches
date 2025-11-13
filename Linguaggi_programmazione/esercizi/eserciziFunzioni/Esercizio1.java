public class Esercizio1 {
  public static void main(String[] args) {
    double base = 5.0;
    double altezza = 3.0;

    double area = calcolaAreaRettangolo(base, altezza);

    System.out.println(area);
  }

  public static double calcolaAreaRettangolo(double base, double altezza){
    return base*altezza;
  }
}
