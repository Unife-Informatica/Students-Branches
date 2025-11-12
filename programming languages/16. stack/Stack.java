public class Stack {
    private int count;
    private String[] items;

    public Stack(int max) {
        count = 0;
        items = new String[max];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    /*
     * Dichiara che durante l'esecuzione della funzione push potrebbe
     * verificarsi un errore di tipo StackOverflowException.
     * Quindi il chiamante deve:
     * - gestirlo con `try-catch`
     * - propagarlo a sua volta con un altro `throws`
     */
    public void push(String value) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        items[count] = value;
        count++;
    }

    public String pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        count--;
        return items[count];
    }
}
