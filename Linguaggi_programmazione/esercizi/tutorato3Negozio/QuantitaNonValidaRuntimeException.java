public class QuantitaNonValidaRuntimeException extends RuntimeException{
  public QuantitaNonValidaRuntimeException(){
    super("Quantità non valida");
  }

  public QuantitaNonValidaRuntimeException(String s){
    super(s);
  }
}
