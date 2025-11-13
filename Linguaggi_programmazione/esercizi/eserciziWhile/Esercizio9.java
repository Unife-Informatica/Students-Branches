public class Esercizio9 {
  public static void main(String[] args) {
    int numero = 1;
    int somma = 0;
    do{
      somma+=numero;
      numero++;
    }while(numero <= 50);
    System.out.println(somma);
  }
}
