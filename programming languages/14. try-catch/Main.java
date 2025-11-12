public class Main {
  public static void main(String[] args) {
    int a = 1;

    try {
      // errore a runtime, "stringa" non è un numero
      a = Integer.parseInt("stringa");
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());  // restituisce il messaggio dell'errore
      a = 0;
    }

    a = a + 2;
    System.out.println(a);
  }
}

