public class PayPal extends MetodoPagamento {
    private String email, password;
    public PayPal(double importo,String email, String password){
        super(importo);
        this.email = email;
        this.password=password;
    }
    @Override
    public boolean autentica(){
        if(!this.containCharacter(this.email,'@')){
            return false;
        }else if(this.password.length()<6){
            return false;
        }
        return true;
    }
    @Override
    public void processamento(){
        System.out.println("Tipo di pagamento: "+getTipo()+".\n Importo: "+importo);
    }
    private boolean containCharacter(String string, char character){
        for(int i=0;i<string.length();i++){
            char act = string.charAt(i);
            if(act==character){
                return true;
            }
        }
        return false;
    }
    @Override
    public String getTipo(){
        return "PayPal";
    }
}
