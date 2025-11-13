public class CartaDiCredito extends Pagamento{
  private String numeroCarta, CVV, nomeTitolare;

  public CartaDiCredito(String numeroCarta, String CVV, String nomeTitolare){
    this.numeroCarta = numeroCarta;
    this.CVV = CVV;
    this.nomeTitolare = nomeTitolare;
  }

  public boolean autenticazione(){
    return CVV.length() == 3;
  }

  public String getDettagli(){
    return "TipoPagamento: CC\nnumero : " + numeroCarta + "\nnomeTitolare: " + nomeTitolare;
  }

  public String getTipoPagamento(){
    return "CC";
  }

  public String getNumeroCarta(){
    return this.numeroCarta;
  }

  public String getCVV(){
    return this.CVV;
  }

  public String getNomeTitolare(){
    return this.nomeTitolare;
  }
}
