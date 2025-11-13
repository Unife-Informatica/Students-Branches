public class Azienda extends Scontrino{
  String ragSociale, indAz;
  int pIva, codCliente;

  public Azienda(String tipoCliente, int id, String data, String ragSociale, int pIva, int codCliente, String indAz){
    super(tipoCliente, id, data);
    this.ragSociale=ragSociale;
    this.pIva=pIva;
    this.codCliente=codCliente;
    this.indAz=indAz;
  }

  public String getRagSociale(){
    return this.ragSociale;
  }

  public int getPIva(){
    return this.pIva;
  }
  
  public int codCliente(){
    return this.codCliente;
  }

  public String getIndAz(){
    return this.indAz;
  }
}