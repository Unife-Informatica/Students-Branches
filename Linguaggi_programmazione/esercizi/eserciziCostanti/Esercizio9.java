public class Esercizio9 {
  public class costantiClasse{
    public static final int MAX_UTENTI = 100;
    public static final String VERSIONE = "1.0.0";
  }

  public static void stampaInfo() {
    System.out.println("Max utenti: " + costantiClasse.MAX_UTENTI);
    System.out.println("Versione: " + costantiClasse.VERSIONE);
  }

  public static void main(String[] args) {
    stampaInfo();
  }
}
