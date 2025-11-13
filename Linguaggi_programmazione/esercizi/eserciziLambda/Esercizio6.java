public class Esercizio6 {
  public static void main(String[] args) {
    VerificatoreNumero verificatore = numero -> numero % 2 == 0;

    int numero = 6;

    boolean isPari = verificatore.verifica(numero);

    if(isPari){
      System.out.println("Pari");
    }else{
      System.out.println("Dispari");
    }
  }
  
  interface VerificatoreNumero{
    boolean verifica(int numero);
  }
}
