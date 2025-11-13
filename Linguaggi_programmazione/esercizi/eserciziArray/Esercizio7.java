public class Esercizio7 {
  public static void main(String[] args) {
    int[] numeri = {5, 10, 15, 20, 25};
    int elementoDaCercare = 15;
    for(int numero : numeri){
      if(elementoDaCercare == numero){
        System.out.println("Trovato.");
        break;
      }
    }
  }
}
