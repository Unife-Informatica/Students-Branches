import java.util.ArrayList;

public class TransazOnline extends Transazione{
  private String ip;

  public TransazOnline(String tipoTr, int id, String data, ArrayList<Libro> listaLibri, String ip){
    super(tipoTr, id, data, listaLibri);
    this.ip=ip;
  }

  public String getDatoExtra(){
    return this.ip;
  }
}
