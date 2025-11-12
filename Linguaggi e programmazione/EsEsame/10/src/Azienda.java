import java.util.List;

public class Azienda extends Cliente{
    String ragSociale;
    float premioCorrenteTax;
    public Azienda(String tipoCliente, int codCliente, int codFiliale, List<Integer> listaExFiliali,
            float premioCorrente, String ragSociale, float premioCorrenteTax) {
        super(tipoCliente, codCliente, codFiliale, listaExFiliali, premioCorrente);
        this.ragSociale = ragSociale;
        this.premioCorrenteTax = premioCorrenteTax;
    }
    public String getRagSociale() {
        return ragSociale;
    }
    public float getPremioCorrenteTax() {
        return premioCorrenteTax;
    }
    
}