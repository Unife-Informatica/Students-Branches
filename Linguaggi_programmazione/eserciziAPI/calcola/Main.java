public class Main {
  public static void main(String[] args) {
    int numeri[] = {1,2,3,4,5,6,7,8,9,10};

    Calcola somma = array -> {
      int totale = 0;
      for(int i = 0; i < array.length; i++){
        totale += array[i];
      }
      return totale;
    };

    int media = somma.calcola(numeri)/numeri.length;
    System.out.println("Media: " + media);

    Calcola massimo = array -> {
      int max = array[0];
      for(int i = 1; i < array.length; i++){
        if(array[i] > max){
          max = array[i];
        }
      }
      return max;
    };
    
    int max = massimo.calcola(numeri);
    System.out.println("Massimo: " + max);

    Calcola minimo = array -> {
      int min = array[0];
      for(int i = 1; i < array.length; i++){
        if(array[i] < min){
          min = array[i];
        }
      }
      return min;
    };

    int min = minimo.calcola(numeri);
    System.out.println("Minimo: " + min);
  }
}
