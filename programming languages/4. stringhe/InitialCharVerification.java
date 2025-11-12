import java.util.Scanner;

public class InitialCharVerification {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Il programma verifica che la stringa inizi con il carattere: ");
    char initialChar = console.next().charAt(0);
    System.out.println("Stringa: ");
    String stringa = console.next();
    
    System.out.println("Risultato: " + firstCharChecker(initialChar, stringa));
    /*
     * Se dovessi controllare se una stringa inizia/finisce con un pattern potrei usare:
     * boolen stringa.startsWith(pattern);
     * boolen stringa.endsWith(pattern);
     */
  }

  public static boolean firstCharChecker(char initialChar, String s) {
    if(initialChar == s.charAt(0)) {
      return true;
    }
    return false;
  }
}
