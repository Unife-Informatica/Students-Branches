public class CounterDec {
  private Counter c;

  public CounterDec() {
    c = new Counter();
  }
  public CounterDec(int initial) {
    c = new Counter(initial);
  }
  public void reset() {
    c.reset();
  }
  public void increment() {
    c.inc(); 
  }
  public int getValue() {
    return c.getValue();
  }
  public void decrement() {
    c.decrement();
  }
}
