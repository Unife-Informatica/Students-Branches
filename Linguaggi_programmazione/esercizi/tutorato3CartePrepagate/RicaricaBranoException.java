public class RicaricaBranoException extends Exception{
  public RicaricaBranoException(){
    super("Ricarica del brano no riuscita");
  }

  public RicaricaBranoException(String s){
    super(s);
  }
}
