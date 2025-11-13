public class Esercizio6 {
  public static void main(String[] args) {
    int numeri[] = {2,5,8,3,9,5,2,1};
    int somma = 0;
    for(int numero : numeri){
      somma+=numero;
    }
    System.out.println(somma/numeri.length);
  }
}
