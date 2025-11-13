public class BonificoBancario extends Pagamento{
  private String IBAN;
  private int codiceSicurezza;

  public BonificoBancario(String IBAN, int codiceSicurezza){
    this.IBAN = IBAN;
    this.codiceSicurezza = codiceSicurezza;
  }

  public boolean autenticazione(){
    if(IBAN.startsWith("IT") && this.codiceSicurezza > 1000){
      return true;
    }else{
      return false;
    }
  }

  public String getDettagli(){
    return "TipoPagamento: Bonifico\nIBAN : " + IBAN + "\ncodice di sicurezza: " + codiceSicurezza;
  }

  public String getTipoPagamento(){
    return "Bonifico";
  }

  public String getIBAN(){
    return this.IBAN;
  }

  public int getCodiceSicurezza(){
    return this.codiceSicurezza;
  }
}
