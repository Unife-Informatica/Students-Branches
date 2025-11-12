public class CartaCredito extends MetodoPagamento {
    private int CVV;
    private String numCarta;
    private String nomeTitolare;
    public CartaCredito(double importo,String numCarta,int CVV,String nomeTitolare){
        super(importo);
        this.numCarta = numCarta;
        this.CVV=CVV;
        this.nomeTitolare=nomeTitolare;
    }
    @Override
    public boolean autentica(){
        return CVV>=100&&CVV<=999;
    }
    @Override
    public void processamento(){
        System.out.println("Tipo di pagamento: "+getTipo()+"\n Importo: "+importo);
    }
    @Override
    public String getTipo(){
        return "Carta di credito";
    }
}
