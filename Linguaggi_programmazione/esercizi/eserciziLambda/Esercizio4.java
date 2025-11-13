public class Esercizio4 {
  public static void main(String[] args) {
    VerificatoreNumero verificatore = numero -> numero > 0;

    int num = 7;

    boolean isPositivo = verificatore.verifica(num);

    if(isPositivo){
      System.out.println("Positivo");
    }else{
      System.out.println("Negativo");
    }
  }

  interface VerificatoreNumero{
    boolean verifica(int numero);
  }
}
