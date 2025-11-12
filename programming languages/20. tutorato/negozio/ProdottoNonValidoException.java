public class ProdottoNonValidoException extends Exception {
  public ProdottoNonValidoException() {
    super("[Errore]: prodotto non valido");
  }

  public ProdottoNonValidoException(String message) {
    super(message);
  }
}
