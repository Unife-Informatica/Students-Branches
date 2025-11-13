public class Esercizio3 {
  public static void main(String[] args) {
    int numeri[] = {2,56,7,3,28,1};
    int min = numeri[0];
    for(int i = 0; i < numeri.length; i++){
      if(numeri[i] < min){
        min = numeri[i];
      }
    }
    System.out.println(min);
  }
}

