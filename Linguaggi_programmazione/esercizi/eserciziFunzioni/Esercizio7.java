public class Esercizio7 {
  public static void main(String[] args) {
    int num = 12345;

    int cifre = contaCifre(num);

    System.out.println(cifre);
  }

  public static int contaCifre(int numero){
    int count = 0;

    while(numero != 0){
      numero /= 10;
      count++;
    }

    return count;
  }
}
