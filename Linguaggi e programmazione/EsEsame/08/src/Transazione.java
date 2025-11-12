import java.util.List;

public abstract class Transazione {
    protected String tipoCliente,data;
    protected int codiceTransazione;
    List<Prodotto> listaProdotti;
    public Transazione(String tipoCliente,int codiceTransazione, String data,List<Prodotto> listaProdotti) {
        this.tipoCliente = tipoCliente;
        this.data = data;
        this.codiceTransazione = codiceTransazione;
        this.listaProdotti=listaProdotti;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public String getData() {
        return data;
    }
    public int getCodiceTransazione() {
        return codiceTransazione;
    }
    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }
    

}
