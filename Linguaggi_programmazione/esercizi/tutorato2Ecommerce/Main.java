public class Main {
  public static void main(String[] args) {
    Utente u1 = new Utente("0", "utente0@example.com");
    Utente u2 = new Utente("Topolino", "topolino@example.com");
    Prodotto p1 = new Prodotto("Lavatrice", 50.17);
    Prodotto p2 = new Prodotto("Frigorifero", 50.17);
    Prodotto p3 = new Prodotto("Tostapane", 35.13);
    Ordine o1 = new Ordine(u1, p1, 13.56, new PayPal("utente", "123"));
    Ordine o2 = new Ordine(u2, p2, 100.99, new BonificoBancario("IT123456", 3042));
    Ordine o3 = new Ordine(u2, p3, 502.89, new CartaDiCredito("gdsfv3", "Topolino", "123"));
    o1.processaOrdine();
    System.out.println();
    o2.processaOrdine();
    System.out.println();
    o3.processaOrdine();
  }
}
