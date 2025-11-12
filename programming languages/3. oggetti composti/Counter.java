public class Counter {
  private int count;

  public Counter() {
    count = 0;
  }

  public Counter(int initial) {
    count = initial;
  }

  public void inc() {
    count++;
  }

  public void decrement() {
    count--;
  }

  public int getValue() {
    return count;
  }

  public void reset() {
    count = 0;
  }
}
