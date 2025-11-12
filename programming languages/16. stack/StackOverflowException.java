public class StackOverflowException extends Exception {
    public StackOverflowException() {
        // passa alla classe Exception un messagio di errore standard
        super("Stack is full");
    }

    public StackOverflowException(String message) {
        // passa il messaggio di errore alla classe Exception
        super(message);
    }
}