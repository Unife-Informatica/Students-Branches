public class FormatoInputNonValidoException extends Exception{
  public FormatoInputNonValidoException(){
    super("Formato non valido");
  }

  public FormatoInputNonValidoException(String s){
    super(s);
  }
}
