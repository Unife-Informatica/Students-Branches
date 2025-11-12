import java.util.List;

public class Professionista extends Transazione {
    String ragioneSociale;
    int pIVA,codCliente;
    public Professionista(String tipoCliente, int codiceTransazione,String data, List<Prodotto> listaProdotti,String ragioneSociale, int pIVA, int codCliente) {
        super(tipoCliente,codiceTransazione, data,listaProdotti);
        this.ragioneSociale = ragioneSociale;
        this.pIVA = pIVA;
        this.codCliente = codCliente;
    }
    public String getRagioneSociale() {
        return ragioneSociale;
    }
    public int getpIVA() {
        return pIVA;
    }
    
    public int getCodCliente() {
        return codCliente;
    }
    
}
