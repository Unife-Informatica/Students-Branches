import java.util.List;

public class Privato extends Cliente{
  private String nome;

  public Privato(String tipoCliente, int codiceIdentif, String indirizzo, String data, String nome, List<Premio> listaPremi){
    super(tipoCliente, codiceIdentif, indirizzo, data, listaPremi);
    this.nome=nome;
  }

  public String getNome() {
    return nome;
  }

  
}
