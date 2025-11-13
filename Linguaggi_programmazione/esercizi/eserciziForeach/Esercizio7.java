public class Esercizio7 {
  public static void main(String[] args) {
    int matrice[][] = {{1,2,3},{4,5,6},{7,8,9}};
    for(int riga[] : matrice){
      for(int elemento : riga){
        System.out.println(elemento);
      }
    }
  }
}
