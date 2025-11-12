public class CartaEsauritaException extends Exception {
  public CartaEsauritaException() {
    super("Carta esaurita");
  }
  public CartaEsauritaException(String message) {
    super(message);
  }
}
