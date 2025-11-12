import java.util.List;

public class Privato extends Cliente{
    String nomeCognome;

    public Privato(String tipoCliente, int codCliente, int codFiliale, List<Integer> listaExFiliali,
            float premioCorrente, String nomeCognome) {
        super(tipoCliente, codCliente, codFiliale, listaExFiliali, premioCorrente);
        this.nomeCognome = nomeCognome;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }
    

}