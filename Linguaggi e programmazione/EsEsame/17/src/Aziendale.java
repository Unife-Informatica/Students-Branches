public class Aziendale extends Scontrino {
    private String ragSociale;
    private String PI;
    private int codCliente;
    private String indirizzo;
    public Aziendale(String tipoCliente,String data, int id,String ragSociale,String PI,int codCliente, String indirizzo){
        super(tipoCliente, id, data);
        this.ragSociale=ragSociale;
        this.PI=PI;
        this.codCliente=codCliente;
        this.indirizzo=indirizzo;
    }
    public String getRagSociale(){
        return ragSociale;
    }
    public String getPI(){
        return PI;
    }
    public int getCodCliente(){
        return codCliente;
    }
    public String getIndirizzo(){
        return indirizzo;
    }
}
