public class Ordine {
   private int codUtente;
   private String prodotto;
   private MetodoPagamento metodoPagamento;
   public Ordine(int codUtente,String prodotto, MetodoPagamento metodoPagamento){
        this.codUtente=codUtente;
        this.prodotto=prodotto;
        this.metodoPagamento=metodoPagamento;
   } 
   public void exeOrdine(){
        if(!metodoPagamento.autentica()){
            System.out.println("Fallita autenticazione del metodo di pagamento: "+metodoPagamento.getTipo()+"\n Del Prodotto: "
            + prodotto + "e utente: "+codUtente );        
        }else{
            metodoPagamento.processamento();
        }
   }
}
