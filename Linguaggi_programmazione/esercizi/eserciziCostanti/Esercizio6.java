public class Esercizio6 {
  public enum Giorno{
    LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA
  }

  public static void main(String[] args) {
    Giorno oggi = Giorno.MERCOLEDI;
    System.out.println("Oggi e': " + oggi);
  }
}
