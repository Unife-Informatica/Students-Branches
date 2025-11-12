import java.util.List;

public abstract class Cliente{
    protected String tipoCliente,indirizzo,data;
    protected int codiceCliente;
    protected List<Premio> listaPremi;
    public Cliente(String tipoCliente, int codiceCliente, String indirizzo, String data,List<Premio> listaPremi){
        this.tipoCliente=tipoCliente;
        this.codiceCliente=codiceCliente;
        this.indirizzo=indirizzo;
        this.data=data;
        this.listaPremi=listaPremi;
    }
    public List<Premio> getListaPremi() {
        return listaPremi;
    }
    public String getTipoCliente(){
        return tipoCliente;
    }
    public int getCodiceCliente(){
        return codiceCliente;
    }
    public String getIndirizzo(){
        return indirizzo;
    }
    public String getData(){
        return data;
    }
}