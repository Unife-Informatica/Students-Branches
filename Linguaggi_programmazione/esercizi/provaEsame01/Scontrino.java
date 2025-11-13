public class Scontrino {
  private int id;
  private String tipoCliente, data;

  public Scontrino(String tipoCliente, int id, String data){
    this.tipoCliente=tipoCliente;
    this.id=id;
    this.data=data;
  }
  
  public String getTipoCliente(){
    return this.tipoCliente;
  }

  public int getId(){
    return this.id;
  }

  public String getData(){
    return this.data;
  }
}
