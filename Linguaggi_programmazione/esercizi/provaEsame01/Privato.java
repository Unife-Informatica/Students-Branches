public class Privato extends Scontrino{
  String nome, cognome, indirizzoPrivato, cf;
  private int codCliente;
  
  public Privato(String tipoCliente, int id, String data, String nome, String cognome, String indirizzoPrivato, String cf, int codCliente){
    super(tipoCliente, id, data);
    this.nome=nome;
    this.cognome=cognome;
    this.indirizzoPrivato=indirizzoPrivato;
    this.cf=cf;
    this.codCliente=codCliente;
  }

  public String getNome(){
    return this.nome;
  }

  public String getCognome(){
    return this.cognome;
  }

  public String getIndirizzoPrivato(){
    return this.indirizzoPrivato;
  }

  public String getCf(){
    return this.cf;
  }

  public int getCodCliente(){
    return this.codCliente;
  }
}
