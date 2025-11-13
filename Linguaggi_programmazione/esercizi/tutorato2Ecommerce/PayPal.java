public class PayPal extends Pagamento{
  private String email, password;

  public PayPal(String email, String password){
    this.email = email;
    this.password = password;
  }

  public boolean autenticazione(){
    if(email.contains("@") && email.length() == 6){
      return true;
    }else{
      return false;
    }
  }

  public String getDettagli() {
    return "TipoPagamento: PayPal\nemail : " + email;
  }

  public String getTipoPagamento() {
    return "PayPal";
  }

  public String getEmail(){
    return this.email;
  }

  public String getPassword(){
    return this.password;
  }
}
