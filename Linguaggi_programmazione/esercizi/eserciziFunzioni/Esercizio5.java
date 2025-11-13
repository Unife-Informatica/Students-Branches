public class Esercizio5 {
  public static void main(String[] args) {
    String parola = "radar";

    boolean isPalindroma = isParolaPalindroma(parola);

    if(isPalindroma){
      System.out.println("E' palindroma");
    }else{
      System.out.println("Non è palindroma");
    }
  }

  public static boolean isParolaPalindroma(String parola){
    String parolaInvertita = "";

    for(int i = parola.length() - 1; i >= 0; i--){
      parolaInvertita += parola.charAt(i);
    }

    return parola.equalsIgnoreCase(parolaInvertita);
  }
}
