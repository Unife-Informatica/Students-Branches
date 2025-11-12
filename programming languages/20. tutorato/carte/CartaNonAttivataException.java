public class CartaNonAttivataException extends Exception {
  public CartaNonAttivataException() {
    super("Carta esaurita");
  }
  public CartaNonAttivataException(String message) {
    super(message);
  }
}