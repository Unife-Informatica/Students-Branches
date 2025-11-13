public class Esercizio2 {
  public static void main(String[] args) {
    double numeri[] = {1.5,2.3,4.7,3.2};
    double somma = 0;
    for(double numero : numeri){
      somma+=numero;
    }
    System.out.println(somma);
  }
}
