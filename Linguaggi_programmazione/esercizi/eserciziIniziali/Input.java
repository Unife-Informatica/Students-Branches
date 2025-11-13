import java.util.Scanner;

public class Input {
  public static void main(String[] args) {
    int n1,n2;
    
    Scanner console = new Scanner(System.in);
    System.out.println("Dammi il primo numero: ");
    n1 = console.nextInt();
    System.out.println("Dammi il secondo numero: ");
    n2 = console.nextInt();
    Integer i1 = Integer.valueOf(n1);
    Integer i2 = Integer.valueOf(n2);
    System.out.println("Il valore sommato e': "+i1.toString()+i2.toString());
  }
}
