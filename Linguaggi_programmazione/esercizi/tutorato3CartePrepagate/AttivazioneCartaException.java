public class AttivazioneCartaException extends Exception{
  public AttivazioneCartaException(){
    super("Attivazione non andata a buon fine");
  }

  public AttivazioneCartaException(String s){
    super(s);
  }
}
