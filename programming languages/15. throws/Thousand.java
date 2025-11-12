public class Thousand {
    // Metodo statico che prova a convertire una stringa in un intero
    // e lancia un'eccezione se il numero è maggiore di 1000.
  public static int parseInt(String s) throws NumberFormatException {
    // Provo a convertire la stringa in un intero usando il metodo della classe
    // Integer
    int a = Integer.parseInt(s);

    // Se il numero è maggiore di 1000, lancio un'eccezione di tipo
    // NumberFormatException
    if (a > 1000) {
      // Creo un'istanza di NumberFormatException
      NumberFormatException e = new NumberFormatException("Il numero è maggiore di 1000");
      // Lancio l'eccezione (throw interrompe il flusso normale e passa il controllo
      // all'handler dell'eccezione)
      throw e;
    }

    // Se tutto va bene, restituisco il numero convertito
    return a;
  }
}
