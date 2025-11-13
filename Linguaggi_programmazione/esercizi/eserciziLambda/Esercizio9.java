public class Esercizio9 {
  public static void main(String[] args) {
    CalcolatorePotenza calcolatore = (base, esponente) -> {
      int ris = 1;
      for(int i = 0; i < esponente; i++){
        ris *= base;
      }
      return ris;
    };

    int base = 2;
    int exp = 5;

    int potenza = calcolatore.calcola(base,exp);

    System.out.println(potenza);
  }

  interface CalcolatorePotenza{
    int calcola(int base, int exp);
  }
}
