import java.util.List;

public class Azienda extends Cliente {
    private String ragioneSociale;
    private int fatturato;
    public Azienda(String tipoCliente, int codiceCliente, String indirizzo, String data,
    String ragioneSociale,int fatturato,List<Premio> listaPremi){
        super(tipoCliente, codiceCliente, indirizzo, data,listaPremi);
        this.ragioneSociale=ragioneSociale;
        this.fatturato=fatturato;
    }
    public String getRagioneSociale(){
        return ragioneSociale;
    }
    public int getFatturato(){
        return fatturato;
    }
}
