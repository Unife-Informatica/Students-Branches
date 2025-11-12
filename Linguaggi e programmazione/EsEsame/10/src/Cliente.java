import java.util.List;

public abstract class Cliente{
    protected String tipoCliente;
    protected int codCliente,codFiliale;
    protected List<Integer> listaExFiliali;
    float premioCorrente;
    public Cliente(String tipoCliente, int codCliente, int codFiliale, List<Integer> listaExFiliali,
            float premioCorrente) {
        this.tipoCliente = tipoCliente;
        this.codCliente = codCliente;
        this.codFiliale = codFiliale;
        this.listaExFiliali = listaExFiliali;
        this.premioCorrente = premioCorrente;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public int getCodCliente() {
        return codCliente;
    }
    public int getCodFiliale() {
        return codFiliale;
    }
    public List<Integer> getListaExFiliali() {
        return listaExFiliali;
    }
    public float getPremioCorrente() {
        return premioCorrente;
    }
}