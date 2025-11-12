public class QuantitaNonValidaRuntimeException extends RuntimeException {
    public QuantitaNonValidaRuntimeException() {
        super("[Errore]: quantità non valida.");
    }

    public QuantitaNonValidaRuntimeException(String message) {
        super(message);
    }
}
