public class Esempio {
  public static void main(String[] args){
    int n, o;
    Counter c1;
    Counter c2;
    c1 = new Counter();
    c2 = new Counter();
    c1.reset();
    c1.inc();
    c1.inc();
    n = c1.getValue();
    System.out.println(n);
    c1.dec();
    n = c1.getValue();
    c2.copy(c1);
    o = c2.getValue();
    System.out.println(n);
    System.out.println(o);
  }
}
