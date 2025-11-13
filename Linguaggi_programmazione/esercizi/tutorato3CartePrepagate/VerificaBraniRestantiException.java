public class VerificaBraniRestantiException extends Exception{
  public VerificaBraniRestantiException(){
    super("Errore durante la verifica dei brani restanti");
  }

  public VerificaBraniRestantiException(String s){
    super(s);
  }
}
