public class Esercizio2 {
  public static void main(String[] args) {
    VerificatoreParola verificatore = (parola, lunghezza) -> parola.length() > lunghezza;

    String parola = "esercizio";
    int lunghezzaMin = 5;

    boolean isLunga = verificatore.verifica(parola, lunghezzaMin);

    if(isLunga){
      System.out.println("La parola è lunga più di " + lunghezzaMin + " caratteri.");
    }else{
      System.out.println("La parola non è lunga più di " + lunghezzaMin + " caratteri.");
    }
  }

  interface VerificatoreParola{
    boolean verifica(String parola, int lunghezza);
  }
}
