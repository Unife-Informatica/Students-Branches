import java.util.Arrays;

public class Esercizio8 {
  public static void main(String[] args) {
    int[] numeri = {1, 2, 3, 4, 5};
    int[] numeriInvertiti = new int[numeri.length];
    int cont = 0;
    for(int i = numeri.length-1; i >= 0; i--){
      numeriInvertiti[cont] = numeri[i];
      cont++;
    }
    System.out.println("Numeri: " + Arrays.toString(numeri));
    System.out.println("Numeri invertiti: " + Arrays.toString(numeriInvertiti));
  }
}
