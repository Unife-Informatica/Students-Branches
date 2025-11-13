public class Ordine {
  private Utente utente;
  private Prodotto prodotto;
  private double importo;
  private Pagamento pagamento;

  public Ordine(Utente utente, Prodotto prodotto, double importo, Pagamento pagamento){
    this.utente = utente;
    this.prodotto = prodotto;
    this.importo = importo;
    this.pagamento = pagamento;
  }

  public void processaOrdine(){
    if(!pagamento.autenticazione()) {
      System.out.println("Fallita autenticazione del metodo di pagamento " +
                                pagamento.getTipoPagamento() +
                                " per il prodotto : " + prodotto.getNome() +
                                " e utente: " + utente.getNome());
    }
    System.out.println("importo: " + importo);
    System.out.println(pagamento.getDettagli());
  }
}
