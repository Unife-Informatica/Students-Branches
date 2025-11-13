public class Esercizio1 {
  public static void main(String[] args) {
    int numeri[] = {1,2,3,4,5,6,7};
    int somma = 0;
    for(int i = 0; i < numeri.length; i++){
      somma+=numeri[i];
    }
    System.out.println(somma);
  }
}
