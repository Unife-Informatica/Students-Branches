public class Esercizio5 {
  public static void main(String[] args) {
    ConcatenatoreStringhe concatenatore = (s1,s2) -> s1 + s2;

    String s1 = "Ciao";
    String s2 = "Mondo!";

    String ris = concatenatore.concatena(s1, s2);

    System.out.println(ris);
  }

  interface ConcatenatoreStringhe{
    String concatena(String s1, String s2);
  }
}
