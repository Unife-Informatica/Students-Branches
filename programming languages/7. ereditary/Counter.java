public class Counter {
  // +-modifier----+-class-+-package-+-subclass-+-world-+
  // | public      | Y     | Y       | Y        | Y     |
  // | protected   | Y     | Y       | Y        | N     |
  // | no modifier | Y     | Y       | N        | N     |
  // | private     | Y     | N       | N        | N     |
  // +-------------+-------+---------+----------+-------+
  protected int val;

  public Counter() {
    val = 0;
  }

  public Counter(int initial) {
    val = initial;
  }

  public void inc() {
    val++;
  }

  public void reset() {
    val = 0;
  }

  public int getValue() {
    return val;
  }
}
