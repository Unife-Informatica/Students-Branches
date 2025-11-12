public class PayPal extends Pagamento {
    private String email;
    private String password;

    public PayPal(double importo, String email, String password) {
        super(importo);
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean autentica() {
        return email.contains("@") && password.length() >= 6;
    }

    @Override
    public String getDettagli() {
        return "TipoPagamento: PayPal\nimporto: " + importo + 
               "\nemail: " + email;
    }

    @Override
    public boolean isRimborsabile() {
        return true;
    }
}

