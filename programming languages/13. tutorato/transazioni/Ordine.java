public class Ordine {
    private String utente;
    private String prodotto;
    private Pagamento pagamento;

    public Ordine(String utente, String prodotto, Pagamento pagamento) {
        this.utente = utente;
        this.prodotto = prodotto;
        this.pagamento = pagamento;
    }

    public void processaOrdine() {
        if (pagamento.autentica()) {
            System.out.println(pagamento.getDettagli());
        } else {
            System.out.println("Fallita autenticazione del metodo di pagamento " +
                pagamento.getClass().getSimpleName() +
                " per il prdotto : " + prodotto + " e utente: " + utente);
        }
    }

    public void rimborsaOrdine() {
        if (pagamento.isRimborsabile()) {
            pagamento.rimborsa();
        }
    }
}

