public class FormatoInputNonValidoException extends Exception {
  public FormatoInputNonValidoException() {
    super("[Errore]: formato input non valido.");
  }

  public FormatoInputNonValidoException(String message) {
    super(message);
  }
}