public class Esercizio7 {
  public static void main(String[] args) {
    int numero = 12345;
    int cont = 0;
    while(numero != 0){
      numero/=10;
      cont++;
    }
    System.out.println(cont);
  }
}
