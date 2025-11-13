public class Esercizio10 {
  public static void main(String[] args) {
    int numero = -5;

    int valoreAssoluto = calcolaValoreAssoluto(numero);

    System.out.println(valoreAssoluto);
  }

  public static int calcolaValoreAssoluto(int numero){
    if(numero < 0){
      return -numero;
    }else{
      return numero;
    }
  }
}
