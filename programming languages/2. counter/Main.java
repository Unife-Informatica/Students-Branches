public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter(0);
        Counter c2 = new Counter(0);
        c1.reset();
        c1.inc();
        c1.inc();
        System.out.println("Counter 1 value: " + c1.getValue());
        c2.copy(c1);
        System.out.println("Counter 2 value (after copy): " + c2.getValue());
    }
}