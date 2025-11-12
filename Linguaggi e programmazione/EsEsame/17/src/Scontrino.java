public class Scontrino {
    protected  String tipoCliente;
    protected int id;
    protected  String data;
    public Scontrino(String tipoCliente, int id,String data){
        this.tipoCliente=tipoCliente;
        this.id=id;
        this.data=data;
    }
    public String getTipoCliente(){
        return tipoCliente;
    }
    public int getId(){
        return id;
    }
    public String getData(){
        return data;
    }
}
