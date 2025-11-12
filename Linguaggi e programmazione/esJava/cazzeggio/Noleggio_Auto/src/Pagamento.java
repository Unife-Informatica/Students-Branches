public class Pagamento{
    private String email;
    private String password;
    double soldiConto;
    public Pagamento(String email, String password){
        this.email = email;
        this.password = password;
        this.soldiConto=300.00;
    }
    public boolean isCorrect(){
        for(int i=0; i<email.length();i++){
            if(email.charAt(i)!='@'){
                return false;
            }
        }
        return password.length()<6;
    }
    public double getSoldi(){
        return soldiConto;
    }
    public void scalaSoldi(double prezzo){
        soldiConto-=prezzo;
    }
}