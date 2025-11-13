public class Esercizio5 {
  public static void main(String[] args) {
    int somma = 0;
    for(int i = 1; i <= 10; i++){
      if(i == 5){
        continue;
      }
      somma+=i;
    }
    System.out.println(somma);
  }
}
