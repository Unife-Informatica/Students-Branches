import java.util.List;

public class Filiale{
    String nome,indirizzo;
    int codFiliale;
    List<Cliente> listaClienti;
    public Filiale(String nome, String indirizzo, int codFiliale, List<Cliente> listaClienti) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.codFiliale = codFiliale;
        this.listaClienti = listaClienti;
    }
    public String getNome() {
        return nome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public int getCodFiliale() {
        return codFiliale;
    }
    public List<Cliente> getListaClienti() {
        return listaClienti;
    }
    
    
}