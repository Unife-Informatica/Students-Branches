public class AcquistoBraniException extends Exception{
  public AcquistoBraniException(){
    super("Acquisto del brano non riuscito");
  }

  public AcquistoBraniException(String s){
    super(s);
  }
}
