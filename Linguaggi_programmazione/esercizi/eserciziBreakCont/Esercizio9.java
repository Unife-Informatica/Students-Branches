public class Esercizio9 {
  public static void main(String[] args) {
    int somma = 0;
    for(int i = 1; i <= 20; i++){
      if(i%4 == 0){
        continue;
      }
      somma+=i;
    }
    System.out.println(somma);
  }
}
