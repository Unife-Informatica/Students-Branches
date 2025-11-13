public class Esercizio4 {
  public static void main(String[] args) {
    float numeri[] = {5.5f,3.2f,22.7f,99.2f};
    float somma = 0;
    for(int i = 0; i < numeri.length; i++){
      somma+=numeri[i];
    }
    System.out.println(somma/numeri.length);
  }
}
