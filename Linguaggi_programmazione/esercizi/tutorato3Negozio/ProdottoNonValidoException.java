public class ProdottoNonValidoException extends Exception{
  public ProdottoNonValidoException(){
    super("Prodotto non valido");
  }

  public ProdottoNonValidoException(String s){
    super(s);
  }
}
