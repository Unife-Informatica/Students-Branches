public class StringBuffer {
  public void main() {
    String s = "Hello World!";
    StringBuffer sb = new StringBuffer(s);

    // copia carattere in ordine inverso
    for (int i = 0; i < sb.lenght()/2; i++) {
      ch = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(sb.lenght()-i-1));
      sb.setCharAt(sb.lenght()-i-1, ch);
    }
  }
}
