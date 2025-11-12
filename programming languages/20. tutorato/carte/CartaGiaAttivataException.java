public class CartaGiaAttivataException extends Exception {
  public CartaGiaAttivataException() {
    super("Carta esaurita");
  }
  public CartaGiaAttivataException(String message) {
    super(message);
  }
}
