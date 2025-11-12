public class Cliente {
    private String codCliente;
    private String nome;
    private String cognome;
    private String codPatente;
    private String dataNascita;
    private Pagamento metodoPagamento;
    public Cliente(String codCliente, String nome, String cognome, String codPatente,String dataNascita,Pagamento metodoPagamento){
        this.codCliente=codCliente;
        this.nome=nome;
        this.cognome=cognome;
        this.codPatente=codPatente;
        this.dataNascita=dataNascita;
        this.metodoPagamento=metodoPagamento;
    }
    public String codCliente(){
        return codCliente;
    }
    public String getNome(){
        return nome;
    }
    public String getCognome(){
        return cognome;
    }
    public String getDataNascita(){
        return dataNascita;
    }
    public Pagamento getMetodoPagamento(){
        return metodoPagamento;
    }
    
}
