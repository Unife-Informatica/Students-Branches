import java.util.Scanner;

public class somma{
  public static void main(String[] args) {
    int a, b, somma;
    Scanner console = new Scanner(System.in);
    a = console.nextInt();
    b = console.nextInt();
    somma = a+b;
    System.out.println("Somma: " + somma);
  }
}