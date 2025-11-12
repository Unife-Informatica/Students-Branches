public class CartaDiCredito extends Pagamento {
    private String numeroCarta;
    private String cvv;
    private String nomeTitolare;

    public CartaDiCredito(double importo, String numeroCarta, String cvv, String nomeTitolare) {
        super(importo);
        this.numeroCarta = numeroCarta;
        this.cvv = cvv;
        this.nomeTitolare = nomeTitolare;
    }

    @Override
    public boolean autentica() {
        return cvv.matches("\\d{3}");
    }

    @Override
    public String getDettagli() {
        return "TipoPagamento: CC\nimporto: " + importo + 
               "\nnumero : " + numeroCarta + 
               "\nnomeTitolare: " + nomeTitolare;
    }
}

