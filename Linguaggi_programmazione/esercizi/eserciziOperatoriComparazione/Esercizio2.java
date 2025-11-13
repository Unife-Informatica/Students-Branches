public class Esercizio2 {
  public static void main(String[] args) {
    int numero = 100;
    String formatta;
    if(numero%2 == 0){
      formatta = String.format("Il numero %d e' pari.", numero);
    }else{
      formatta = String.format("Il numero %d e' dispari.", numero);
    }
    System.out.println(formatta);
  }
}
