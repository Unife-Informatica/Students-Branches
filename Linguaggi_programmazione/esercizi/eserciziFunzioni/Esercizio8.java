public class Esercizio8 {
  public static void main(String[] args) {
    int base = 2;
    int exp = 5;

    int potenza = calcolaPotenza(base, exp);

    System.out.println(potenza);
  }

  public static int calcolaPotenza(int base, int exp){
    int risultato = 1;

    for(int i = 0; i < exp; i++){
      risultato *= base;
    }

    return risultato;
  }
}
