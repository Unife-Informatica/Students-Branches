import java.util.ArrayList;

public class Esercizio1 {
  public static void main(String[] args) {
    ArrayList<Integer> numeri = new ArrayList<>();
    numeri.add(5);
    numeri.add(6);
    numeri.add(76);
    numeri.add(34);
    numeri.add(23);
    for(int numero : numeri){
      System.out.println(numero);
    }
  }
}
