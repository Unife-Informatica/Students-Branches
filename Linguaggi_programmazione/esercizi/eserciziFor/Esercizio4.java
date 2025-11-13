public class Esercizio4 {
  public static void main(String[] args) {
    int prodotto = 0;
    for(int i=1; i<=15;i++){
      if(i%2 != 0){
        prodotto*=i;
      }
    }
    System.out.println(prodotto);
  }
}
