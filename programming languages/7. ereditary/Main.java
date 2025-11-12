public class Main {
  public void main() {
    BiCounter bc;
    bc = new BiCounter();
    bc.inc();
    bc.inc();
    bc.dec();
    System.out.println(bc.getValue());
  }
}
