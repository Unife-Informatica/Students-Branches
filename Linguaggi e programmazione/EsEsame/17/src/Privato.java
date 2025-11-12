
import javax.xml.crypto.Data;

public class Privato extends Scontrino{
    private String nome;
    private String cognome;
    private String indirizzo;
    private String CF;
    private int codCliente;
    public Privato(String tipoCliente,String data,int id,String nome, String cognome, String indirizzo,String CF,int codCliente){
        super(tipoCliente, id, data);
        this.nome=nome;
        this.cognome=cognome;
        this.indirizzo=indirizzo;
        this.CF=CF;
        this.codCliente=codCliente;

    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getIndirizzo(){
        return indirizzo;
    }
    public String getCF(){
        return CF;
    }
    @Override
    public String toString(){
        return "codCliente: "+codCliente+"data: "+data+" id: "+id+" nome: "+nome;
    }

}
