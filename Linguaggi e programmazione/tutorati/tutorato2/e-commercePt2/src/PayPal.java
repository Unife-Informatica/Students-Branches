public class PayPal extends MetodoPagamento {
    private String email, password;
    public PayPal(double importo, String email,String password){
        super(importo);
        this.email=email;
        this.password=password;
    }
    @Override
    public boolean verifica(){
        return isChar(this.email,'@')&&password.length()>=6;
    }
    public void processamento(){
        if(verifica())
            System.out.println("")
    }
    public boolean isChar(String string,char controlChar){
        for(int i=0; i<string.length();i++){
            if(string.charAt(i)==controlChar)
                return true;
        }
        return false;
        
    }
}
