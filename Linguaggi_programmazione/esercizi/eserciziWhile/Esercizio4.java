public class Esercizio4 {
  public static void main(String[] args) {
    int numero = 1;
    int prodotto = 0;
    while(numero <= 15){
      if(numero%2 != 0){
        prodotto*=numero;
      }
    }
    System.out.println(prodotto);
  }
}
