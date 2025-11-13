import java.util.Arrays;

public class Esercizio6 {
  public static void main(String[] args) {
    int[] numeri1 = {1, 2, 3, 4, 5};
    int[] numeri2 = new int[numeri1.length];
    for(int i = 0; i < numeri1.length; i++){
      numeri2[i] = numeri1[i];
    }
    System.out.println("Numeri1: " + Arrays.toString(numeri1));
    System.out.println("Numeri2: " + Arrays.toString(numeri2));
  }
}
