public class Esercizio2 {
  public static void main(String[] args) {
    int numeri[] = {2,56,7,3,28,1};
    int max = 0;
    for(int i = 0; i < numeri.length; i++){
      if(numeri[i] > max){
        max = numeri[i];
      }
    }
    System.out.println(max);
  }
}
