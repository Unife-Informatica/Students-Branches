public class BonificoBancario extends MetodoPagamento{
    private String IBAN;
    private int codiceSicurezza;
    public BonificoBancario(double importo, String IBAN, int codiceSicurezza){
        super(importo);
        this.IBAN=IBAN;
        this.codiceSicurezza=codiceSicurezza;
    }
    @Override
    public boolean autentica(){
        if(!IBAN.substring(0,2).equals("IT")){
            return false;
        }else if(codiceSicurezza<1000){
            return false;
        }
        return true;
    }
    @Override
    public void processamento(){
        System.out.println("Metodo di pagamento: "+getTipo()+"/n Importo: "+importo);
    }
    @Override
    public String getTipo(){
        return "Bonifico Bancario";
    }
}
