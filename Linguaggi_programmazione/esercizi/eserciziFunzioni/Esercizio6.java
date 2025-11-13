public class Esercizio6 {
  public static void main(String[] args) {
    int n1 = 10;
    int n2 = 7;
    int n3 = 12;

    int max = calcolaMassimo(n1, n2, n3);

    System.out.println(max);
  }

  public static int calcolaMassimo(int n1, int n2, int n3){
    int max = n1;

    if(n2 > max){
      max = n2;
    }

    if(n3 > max){
      max = n3;
    }

    return max;
  } 
}
