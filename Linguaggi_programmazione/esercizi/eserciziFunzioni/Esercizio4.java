public class Esercizio4 {
  public static void main(String[] args) {
    int num = 5;

    int fattoriale = calcolaFattoriale(num);

    System.out.println(fattoriale);
  }

  public static int calcolaFattoriale(int numero){
    if(numero == 0){
      return 1;
    }else{
      return numero*calcolaFattoriale(numero - 1);
    }
  }
}
