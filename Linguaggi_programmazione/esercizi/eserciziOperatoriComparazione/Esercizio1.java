public class Esercizio1 {
  public static void main(String[] args) {
    int numero = 123;
    String formatta;
    if(numero > 0){
      formatta = String.format("Il numero %d e' positivo.", numero);
    }else{
      formatta = String.format("Il numero %d e' negativo.", numero);
    }
    System.out.println(formatta);
  }
}
