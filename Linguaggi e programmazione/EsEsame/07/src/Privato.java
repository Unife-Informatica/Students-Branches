import java.util.List;

public class Privato extends Cliente {
    private String nome;
    public Privato(String tipoCliente, int codiceCliente, String indirizzo, String data,String nome,List<Premio> listaPremi){
        super(tipoCliente, codiceCliente, indirizzo, data,listaPremi);
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
}
