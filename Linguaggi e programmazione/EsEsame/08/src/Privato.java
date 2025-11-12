import java.util.List;

public class Privato extends Transazione{
    String nomeCognome,indirizzo,CF;
    public Privato(String tipoCliente, String data, int codiceTransazione, List<Prodotto> listaProdotti, String nomeCognome,String indirizzo, String CF) {
        super(tipoCliente, codiceTransazione, data, listaProdotti);
        this.nomeCognome = nomeCognome;
        this.indirizzo = indirizzo;
        this.CF = CF;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCF() {
        return CF;
    }
    
    
    
}