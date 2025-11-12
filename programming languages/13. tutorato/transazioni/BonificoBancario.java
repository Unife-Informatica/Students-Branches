public class BonificoBancario extends Pagamento {
    private String iban;
    private int codiceSicurezza;

    public BonificoBancario(double importo, String iban, int codiceSicurezza) {
      /*
       * richiama la classe Pagamento e gli passa importo come parametro
       */
      super(importo);
      this.iban = iban;
      this.codiceSicurezza = codiceSicurezza;
    }

    @Override
    public boolean autentica() {
        return iban.startsWith("IT") && codiceSicurezza > 1000;
    }

    @Override
    public String getDettagli() {
        return "TipoPagamento: Bonifico\nimporto: " + importo +
               "\niban : " + iban +
               "\ncodiceSicurezza: " + codiceSicurezza;
    }
}

